package com.rax.core.viewmodels

import com.rax.core.repository.exceptions.ApiException
import com.rax.core.repository.exceptions.ResponseException
import com.squareup.moshi.JsonDataException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.mapExceptionMessage(): String = when (this) {
    is ApiException -> {
        this.errorEnvelope.message.orEmpty()
    }
    is JsonDataException,
    is IllegalArgumentException,
    is UnknownHostException,
    is ResponseException,
    is SocketTimeoutException -> {
        "Bad connection error"
    }
    else -> "Something went wrong"
}
