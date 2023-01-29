package com.rax.photos.overview.data.mappers

import com.rax.photos.overview.data.envelopes.PhotoEnvelope
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalStdlibApi::class)
class PhotoEnvelopeMapperTest {

    private val moshi = Moshi.Builder()
        .build()

    @Test
    fun `map photo envelope to model`() {
        val jsonFile = ClassLoader.getSystemResource("photos_list.json")
        val json = jsonFile.readText()
        val envelope = requireNotNull(moshi.adapter<PhotoEnvelope>().fromJson(json))
        val result = PhotoEnvelopeMapper.mapFrom(envelope)
        assertEquals(1, result.id)
        assertEquals(1, result.albumId)
        assertEquals("https://via.placeholder.com/600/92c952", result.photoUrl)
        assertEquals("https://via.placeholder.com/150/92c952", result.thumbnailUrl)
        assertEquals("accusamus beatae ad facilis cum similique qui sunt", result.title)
    }
}
