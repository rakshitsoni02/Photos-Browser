package com.rax.photos.overview.data.envelopes

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalStdlibApi::class)
class PhotoEnvelopeTest {

    private val moshi = Moshi.Builder()
        .build()

    @Test
    fun `parse photo json to envelope`() {
        val jsonFile = ClassLoader.getSystemResource("photos_list.json")
        val json = jsonFile.readText()

        val envelope = requireNotNull(moshi.adapter<PhotoEnvelope>().fromJson(json))

        assertEquals(1, envelope.id)
        assertEquals(1, envelope.albumId)
        assertEquals("https://via.placeholder.com/600/92c952", envelope.photoUrl)
        assertEquals("https://via.placeholder.com/150/92c952", envelope.thumbnailUrl)
        assertEquals("accusamus beatae ad facilis cum similique qui sunt", envelope.title)
    }
}
