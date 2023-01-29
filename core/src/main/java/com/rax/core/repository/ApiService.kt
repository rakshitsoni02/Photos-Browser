package com.rax.core.repository

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Url

interface ApiService {

    @GET
    fun get(
        @HeaderMap headerMap: Map<String, String>,
        @Url url: String
    ): Single<Response<String>>

}
