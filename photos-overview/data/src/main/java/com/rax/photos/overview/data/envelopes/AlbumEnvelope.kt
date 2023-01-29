package com.rax.photos.overview.data.envelopes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumEnvelope(
    @Json(name = "id")
    val id: Int,
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "title")
    val title: String
)