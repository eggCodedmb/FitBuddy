package com.anant.fitbuddy.data.backup.webdav

import com.anant.fitbuddy.BuildConfig
import com.anant.fitbuddy.data.backup.BackupChunkIds
import com.anant.fitbuddy.data.backup.BackupData
import com.anant.fitbuddy.data.backup.mongo.CloudBackupDoc
import com.anant.fitbuddy.data.backup.mongo.MongoBackupRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Credentials
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

/**
 * Cloud backup over WebDAV (Jianguoyun / 坚果云 or any WebDAV server).
 *
 * Layout: `{url}/{directory}/{supportId}/chunk-{n}.json`. Each file holds the same fields as a
 * proxy document ([CloudBackupDoc]) — `payloadJson` is the already-sealed (encrypted) backup
 * envelope, so the WebDAV host never sees plaintext data. The chunk chain is followed through
 * `nextChunkId`, exactly like the former Atlas proxy.
 *
 * Extends [MongoBackupRepository] so the existing chunking / encryption / restore logic in
 * `FitnessRepository` keeps working unchanged; the proxy-only `baseUrl` / `apiKey` /
 * `databaseName` / `collectionName` arguments are ignored here.
 */
open class WebDavBackupRepository(
    private val credentialsProvider: suspend () -> WebDavCredentials,
    private val http: OkHttpClient = defaultClient()
) : MongoBackupRepository(http) {

    override suspend fun uploadChunk(
        baseUrl: String,
        apiKey: String,
        databaseName: String,
        collectionName: String,
        supportId: String,
        chunkId: String,
        chunkIndex: Int,
        nextChunkId: String?,
        tipChunkId: String?,
        payloadJson: String,
        exportedAt: Long,
        deviceName: String,
        macId: String,
        headTipChunkId: String?
    ) {
        val creds = requireCredentials()
        val id = supportId.trim()
        require(id.isNotBlank()) { "Support ID is blank — cannot upload backup" }
        val body = JSONObject()
            .put("supportId", id)
            .put("payloadJson", payloadJson)
            .put("schemaVersion", BackupData.CURRENT_VERSION)
            .put("exportedAt", exportedAt)
            .put("appPackage", BuildConfig.APPLICATION_ID)
            .put("deviceName", deviceName.trim().take(128))
            .put("macId", macId.trim().take(64))
            .put("chunkId", chunkId.trim())
            .put("chunkIndex", chunkIndex)
            .put("storageVersion", 2)
            .put("nextChunkId", nextChunkId ?: JSONObject.NULL)
            .put("tipChunkId", tipChunkId ?: JSONObject.NULL)
            .toString()

        withContext(Dispatchers.IO) {
            ensureCollection(creds, creds.directoryUrl())
            ensureCollection(creds, supportFolderUrl(creds, id))
            val request = Request.Builder()
                .url(fileUrl(creds, id, chunkId))
                .header("Authorization", auth(creds))
                .put(body.toRequestBody(JSON_MEDIA_TYPE))
                .build()
            http.newCall(request).execute().use { response ->
                if (!response.isSuccessful) error(httpError("upload", response.code))
            }
        }
    }

    override suspend fun downloadDoc(
        baseUrl: String,
        apiKey: String,
        databaseName: String,
        collectionName: String,
        supportId: String,
        chunkId: String?
    ): CloudBackupDoc {
        val creds = requireCredentials()
        val id = supportId.trim()
        require(id.isNotBlank()) { "Support ID is required to restore" }
        val resolvedChunk = chunkId?.trim().orEmpty().ifBlank { id }
        return withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .url(fileUrl(creds, id, resolvedChunk))
                .header("Authorization", auth(creds))
                .get()
                .build()
            http.newCall(request).execute().use { response ->
                if (response.code == 404) error("No cloud backup found for Support ID $id")
                if (!response.isSuccessful) error(httpError("download", response.code))
                parseFile(response.body.string(), id, resolvedChunk)
            }
        }
    }

    /** Verifies the account and creates the backup folder. Throws with a readable message. */
    open suspend fun testConnection() {
        val creds = requireCredentials()
        withContext(Dispatchers.IO) { ensureCollection(creds, creds.directoryUrl()) }
    }

    /**
     * Support IDs that have a backup on the server, newest first (by folder modification time).
     * Lets a fresh install restore without typing the Support ID.
     */
    open suspend fun listSupportIds(): List<String> {
        val creds = requireCredentials()
        return withContext(Dispatchers.IO) {
            val dirUrl = creds.directoryUrl()
            val request = Request.Builder()
                .url(dirUrl)
                .header("Authorization", auth(creds))
                .header("Depth", "1")
                .method("PROPFIND", PROPFIND_BODY.toRequestBody(XML_MEDIA_TYPE))
                .build()
            http.newCall(request).execute().use { response ->
                if (response.code == 404) return@use emptyList()
                if (!response.isSuccessful) error(httpError("list", response.code))
                parseSupportIds(response.body.string(), dirUrl)
            }
        }
    }

    // ----- helpers -------------------------------------------------------------------------------

    private suspend fun requireCredentials(): WebDavCredentials {
        val creds = credentialsProvider()
        if (!creds.isComplete) error("WebDAV account is not configured (Settings → Backup)")
        return creds
    }

    private fun ensureCollection(creds: WebDavCredentials, url: String) {
        val request = Request.Builder()
            .url(url)
            .header("Authorization", auth(creds))
            .method("MKCOL", null)
            .build()
        http.newCall(request).execute().use { response ->
            // 201 Created; 405 Method Not Allowed = already exists (Jianguoyun may also reply 201).
            if (response.isSuccessful || response.code == 405) return
            error(httpError("create folder", response.code))
        }
    }

    private fun auth(creds: WebDavCredentials): String =
        Credentials.basic(creds.user.trim(), creds.password, Charsets.UTF_8)

    private fun supportFolderUrl(creds: WebDavCredentials, supportId: String): String =
        creds.directoryUrl() + encodeSegment(supportId) + "/"

    private fun fileUrl(creds: WebDavCredentials, supportId: String, chunkId: String): String =
        supportFolderUrl(creds, supportId) + fileNameFor(supportId, chunkId)

    private fun httpError(action: String, code: Int): String = when (code) {
        401 -> "WebDAV $action failed: wrong account or app password (HTTP 401)"
        403 -> "WebDAV $action failed: access denied (HTTP 403)"
        409 -> "WebDAV $action failed: parent folder missing (HTTP 409)"
        503 -> "WebDAV $action failed: rate limited, try again later (HTTP 503)"
        else -> "WebDAV $action failed (HTTP $code)"
    }

    private fun parseFile(bodyString: String, supportId: String, fallbackChunkId: String): CloudBackupDoc {
        val json = runCatching { JSONObject(bodyString) }.getOrNull()
            ?: error("Cloud backup file is not valid JSON")
        val payloadJson = json.optString("payloadJson").takeIf { it.isNotBlank() }
            ?: error("Cloud backup is missing payloadJson")
        return CloudBackupDoc(
            supportId = json.optString("supportId").ifBlank { supportId },
            chunkId = json.optString("chunkId").ifBlank { fallbackChunkId },
            chunkIndex = json.optInt("chunkIndex", 0),
            nextChunkId = optionalChunkRef(json, "nextChunkId"),
            tipChunkId = optionalChunkRef(json, "tipChunkId"),
            storageVersion = json.optInt("storageVersion", 2),
            schemaVersion = json.optInt("schemaVersion", 0),
            exportedAt = json.optLong("exportedAt", 0L),
            appPackage = json.optString("appPackage"),
            deviceName = json.optString("deviceName"),
            macId = json.optString("macId"),
            payloadJson = payloadJson
        )
    }

    companion object {
        private val JSON_MEDIA_TYPE = "application/json; charset=utf-8".toMediaType()
        private val XML_MEDIA_TYPE = "application/xml; charset=utf-8".toMediaType()
        private const val PROPFIND_BODY =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<d:propfind xmlns:d=\"DAV:\"><d:prop><d:resourcetype/><d:getlastmodified/>" +
                "</d:prop></d:propfind>"

        private fun defaultClient(): OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        /** `chunk-0.json` for the head, `chunk-{n}.json` for later nodes (no `:` in file names). */
        internal fun fileNameFor(supportId: String, chunkId: String): String {
            val trimmedCid = chunkId.trim()
            val trimmedSid = supportId.trim()
            val index = BackupChunkIds.parseChunkIndex(trimmedCid, trimmedSid)
                ?: if (trimmedCid == "$trimmedSid${BackupChunkIds.SEPARATOR}0") 0 else null
            return if (index != null) {
                "chunk-$index.json"
            } else {
                "chunk-" + trimmedCid.replace(Regex("[^A-Za-z0-9._-]"), "_") + ".json"
            }
        }

        internal fun encodeSegment(segment: String): String =
            URLEncoder.encode(segment.trim(), "UTF-8").replace("+", "%20")

        /**
         * Extracts direct child folder names of [dirUrl] from a PROPFIND multistatus response,
         * newest first. Pure function for unit tests.
         */
        internal fun parseSupportIds(xml: String, dirUrl: String): List<String> {
            val dirPath = runCatching { java.net.URI(dirUrl).rawPath }.getOrNull()
                ?.trimEnd('/')?.lowercase() ?: return emptyList()
            val responseRegex = Regex("<(?:\\w+:)?response\\b[\\s\\S]*?</(?:\\w+:)?response>", RegexOption.IGNORE_CASE)
            val hrefRegex = Regex("<(?:\\w+:)?href>([\\s\\S]*?)</(?:\\w+:)?href>", RegexOption.IGNORE_CASE)
            val collectionRegex = Regex("<(?:\\w+:)?collection\\s*/>", RegexOption.IGNORE_CASE)
            val modifiedRegex = Regex(
                "<(?:\\w+:)?getlastmodified>([\\s\\S]*?)</(?:\\w+:)?getlastmodified>",
                RegexOption.IGNORE_CASE
            )
            val httpDate = java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", java.util.Locale.US)
            return responseRegex.findAll(xml).mapNotNull { match ->
                val block = match.value
                if (!collectionRegex.containsMatchIn(block)) return@mapNotNull null
                val href = hrefRegex.find(block)?.groupValues?.get(1)?.trim() ?: return@mapNotNull null
                val path = runCatching { java.net.URI(href).rawPath }.getOrNull() ?: href
                val trimmed = path.trimEnd('/')
                if (trimmed.lowercase() == dirPath) return@mapNotNull null
                val parent = trimmed.substringBeforeLast('/').lowercase()
                if (parent != dirPath) return@mapNotNull null
                val name = URLDecoder.decode(trimmed.substringAfterLast('/'), "UTF-8")
                if (!BackupChunkIds.isValidSupportId(name)) return@mapNotNull null
                val modified = modifiedRegex.find(block)?.groupValues?.get(1)?.trim()
                    ?.let { runCatching { httpDate.parse(it)?.time }.getOrNull() } ?: 0L
                name to modified
            }.sortedByDescending { it.second }.map { it.first }.distinct().toList()
        }
    }
}
