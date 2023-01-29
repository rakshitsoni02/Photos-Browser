package com.rax.core.repository

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorEnvelope(
    @Json(name = "error")
    val error: String? = null,
    @Json(name = "error_description")
    val message: String? = null
)
