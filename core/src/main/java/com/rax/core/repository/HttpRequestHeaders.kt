package com.rax.core.repository

object HttpRequestHeaders {
    // keys
    const val ACCEPT = "Accept"
    const val ACCEPT_LANGUAGE = "Accept-Language"
    const val CONTENT_TYPE = "Content-Type"
    const val USER_AGENT = "user-agent"
    const val AUTHORIZATION = "Authorization"
    const val REQUEST_ID = "x-request-id"

    // values
    const val APPLICATION_JSON = "application/json"
    const val BEARER = "Bearer"
    const val BEARER_AUTH_FORMAT = "$BEARER %s"
}
