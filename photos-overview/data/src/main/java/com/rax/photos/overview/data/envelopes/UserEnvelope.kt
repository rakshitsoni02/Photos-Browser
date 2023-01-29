package com.rax.photos.overview.data.envelopes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserEnvelope(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "email")
    val email: String
)