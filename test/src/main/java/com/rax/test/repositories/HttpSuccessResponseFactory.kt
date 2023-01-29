package com.rax.test.repositories

import com.rax.core.repository.HttpSuccessResponse

object HttpSuccessResponseFactory {

    fun create(
        code: Int = 200,
        body: String = "{}",
        headers: Map<String, String> = emptyMap()
    ): HttpSuccessResponse {
        return HttpSuccessResponse(code, body, headers)
    }
}
