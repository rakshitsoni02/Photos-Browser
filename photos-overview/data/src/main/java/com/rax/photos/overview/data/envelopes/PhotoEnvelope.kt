package com.rax.photos.overview.data.envelopes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoEnvelope(
    @Json(name = "id")
    val id: Int,
    @Json(name = "albumId")
    val albumId: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "url")
    val photoUrl: String,
    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String
)