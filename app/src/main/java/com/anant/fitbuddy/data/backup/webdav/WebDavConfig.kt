package com.anant.fitbuddy.data.backup.webdav

import com.anant.fitbuddy.BuildConfig
import com.anant.fitbuddy.data.backup.mongo.MongoUriVault

/** Resolved WebDAV endpoint + account used for cloud backup (e.g. Jianguoyun / 坚果云). */
data class WebDavCredentials(
    val url: String,
    val user: String,
    val password: String,
    val directory: String
) {
    val isComplete: Boolean
        get() = url.isNotBlank() && user.isNotBlank() && password.isNotBlank()

    /** `https://host/dav/` + `fit/` — always ends with a single slash. */
    fun directoryUrl(): String {
        val base = url.trim().trimEnd('/') + "/"
        val dir = directory.trim().trim('/')
        return if (dir.isEmpty()) base else "$base$dir/"
    }
}

/**
 * Build-time WebDAV defaults (from `local.properties`, never committed). The password is
 * XOR + Base64 obfuscated in BuildConfig; users can override everything in Settings → Backup.
 */
object WebDavConfig {
    const val JIANGUOYUN_URL = "https://dav.jianguoyun.com/dav/"
    const val DEFAULT_DIRECTORY = "fit"

    val defaultUrl: String
        get() = BuildConfig.WEBDAV_URL.trim().ifBlank { JIANGUOYUN_URL }

    val defaultUser: String
        get() = BuildConfig.WEBDAV_USER.trim()

    val defaultDirectory: String
        get() = BuildConfig.WEBDAV_DIR.trim().ifBlank { DEFAULT_DIRECTORY }

    val defaultPassword: String by lazy {
        val blob = BuildConfig.WEBDAV_PASSWORD_BLOB
        if (blob.isBlank()) "" else runCatching {
            MongoUriVault.decode(blob, BuildConfig.WEBDAV_PASSWORD_MASK)
        }.getOrDefault("")
    }

    /** True when this build ships a complete default account (restore during onboarding). */
    fun hasBuiltInAccount(): Boolean =
        defaultUrl.isNotBlank() && defaultUser.isNotBlank() && defaultPassword.isNotBlank()
}
