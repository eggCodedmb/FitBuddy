package com.anant.fitbuddy.data.backup.webdav

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WebDavBackupRepositoryTest {

    @Test
    fun credentials_directoryUrl_normalizesTrailingSlashes() {
        val creds1 = WebDavCredentials(
            url = "https://dav.jianguoyun.com/dav",
            user = "user@test.com",
            password = "pw",
            directory = "fit"
        )
        assertEquals("https://dav.jianguoyun.com/dav/fit/", creds1.directoryUrl())

        val creds2 = WebDavCredentials(
            url = "https://dav.jianguoyun.com/dav/",
            user = "user@test.com",
            password = "pw",
            directory = "/fit/"
        )
        assertEquals("https://dav.jianguoyun.com/dav/fit/", creds2.directoryUrl())

        val credsEmptyDir = WebDavCredentials(
            url = "https://dav.jianguoyun.com/dav/",
            user = "user@test.com",
            password = "pw",
            directory = ""
        )
        assertEquals("https://dav.jianguoyun.com/dav/", credsEmptyDir.directoryUrl())
    }

    @Test
    fun credentials_isComplete() {
        assertTrue(
            WebDavCredentials(
                url = "https://dav.jianguoyun.com/dav/",
                user = "user@test.com",
                password = "secret",
                directory = "fit"
            ).isComplete
        )
        assertFalse(
            WebDavCredentials(
                url = "",
                user = "user@test.com",
                password = "secret",
                directory = "fit"
            ).isComplete
        )
        assertFalse(
            WebDavCredentials(
                url = "https://dav.jianguoyun.com/dav/",
                user = "",
                password = "secret",
                directory = "fit"
            ).isComplete
        )
        assertFalse(
            WebDavCredentials(
                url = "https://dav.jianguoyun.com/dav/",
                user = "user@test.com",
                password = "",
                directory = "fit"
            ).isComplete
        )
    }

    @Test
    fun fileNameFor_mapsHeadAndNumberedChunks() {
        val supportId = "25547434-8000-4000-8000-000000000001"
        assertEquals("chunk-0.json", WebDavBackupRepository.fileNameFor(supportId, supportId))
        assertEquals("chunk-0.json", WebDavBackupRepository.fileNameFor(supportId, "$supportId::c::0"))
        assertEquals("chunk-1.json", WebDavBackupRepository.fileNameFor(supportId, "$supportId::c::1"))
        assertEquals("chunk-5.json", WebDavBackupRepository.fileNameFor(supportId, "$supportId::c::5"))
    }

    @Test
    fun encodeSegment_escapesSpacesAndSpecialChars() {
        assertEquals("my%20folder", WebDavBackupRepository.encodeSegment("my folder"))
        assertEquals("support%3Aid", WebDavBackupRepository.encodeSegment("support:id"))
    }

    @Test
    fun parseSupportIds_extractsChildFoldersSortedByTime() {
        val dirUrl = "https://dav.jianguoyun.com/dav/fit/"
        val xml = """
            <?xml version="1.0" encoding="utf-8"?>
            <d:multistatus xmlns:d="DAV:">
                <d:response>
                    <d:href>/dav/fit/</d:href>
                    <d:propstat>
                        <d:prop>
                            <d:resourcetype><d:collection/></d:resourcetype>
                        </d:prop>
                    </d:propstat>
                </d:response>
                <d:response>
                    <d:href>/dav/fit/11111111-1111-4111-8111-111111111111/</d:href>
                    <d:propstat>
                        <d:prop>
                            <d:resourcetype><d:collection/></d:resourcetype>
                            <d:getlastmodified>Wed, 01 Jan 2025 10:00:00 GMT</d:getlastmodified>
                        </d:prop>
                    </d:propstat>
                </d:response>
                <d:response>
                    <d:href>/dav/fit/22222222-2222-4222-8222-222222222222/</d:href>
                    <d:propstat>
                        <d:prop>
                            <d:resourcetype><d:collection/></d:resourcetype>
                            <d:getlastmodified>Wed, 01 Jan 2025 12:00:00 GMT</d:getlastmodified>
                        </d:prop>
                    </d:propstat>
                </d:response>
                <d:response>
                    <d:href>/dav/fit/random-file.txt</d:href>
                    <d:propstat>
                        <d:prop>
                            <d:resourcetype/>
                            <d:getlastmodified>Wed, 01 Jan 2025 13:00:00 GMT</d:getlastmodified>
                        </d:prop>
                    </d:propstat>
                </d:response>
            </d:multistatus>
        """.trimIndent()

        val result = WebDavBackupRepository.parseSupportIds(xml, dirUrl)
        assertEquals(2, result.size)
        // Newest (12:00) should come before older (10:00)
        assertEquals("22222222-2222-4222-8222-222222222222", result[0])
        assertEquals("11111111-1111-4111-8111-111111111111", result[1])
    }
}
