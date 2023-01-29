package com.rax.core.repository

import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody

interface HttpRequestFactoryType {

    fun create(
        transition: HttpTransition,
        headers: Map<String, String>? = null,
        parameters: String? = null,
        multipartBody: MultipartBody.Part? = null
    ): Single<HttpSuccessResponse>
}
