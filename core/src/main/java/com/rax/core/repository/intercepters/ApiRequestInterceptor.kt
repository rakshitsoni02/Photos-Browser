package com.rax.core.repository.intercepters

import com.rax.core.repository.HttpRequestHeaders
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class ApiRequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val modifiedRequest = modifyRequest(chain.request())
        return chain.proceed(modifiedRequest)
    }

    private fun modifyRequest(initialRequest: Request): Request {
        val requestBuilder = initialRequest.newBuilder()
            .header(HttpRequestHeaders.ACCEPT, HttpRequestHeaders.APPLICATION_JSON)
            .header(HttpRequestHeaders.USER_AGENT, "Photos Android")

        return requestBuilder.build()
    }
}