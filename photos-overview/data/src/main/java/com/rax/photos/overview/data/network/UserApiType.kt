package com.rax.photos.overview.data.network

import com.rax.core.repository.HttpSuccessResponse
import io.reactivex.rxjava3.core.Single

interface UserApiType {
    fun fetchUsers(): Single<HttpSuccessResponse>
}