package com.rax.core.repository.exceptions

open class ResponseException(
    val responseCode: Int,
    val requestId: String
) : RuntimeException()
