package com.rax.core.repository.exceptions

import com.rax.core.repository.ErrorEnvelope

class ApiException(
    responseCode: Int,
    requestId: String,
    val errorEnvelope: ErrorEnvelope
) : ResponseException(responseCode, requestId)
