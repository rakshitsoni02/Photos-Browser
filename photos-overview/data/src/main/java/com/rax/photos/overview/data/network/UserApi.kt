package com.rax.photos.overview.data.network

import com.rax.core.BuildConfig
import com.rax.core.repository.HttpRequestFactoryType
import com.rax.core.repository.HttpSuccessResponse
import com.rax.core.repository.HttpTransition
import com.rax.core.repository.HttpVerb
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserApi @Inject constructor(
    private val httpRequestFactory: HttpRequestFactoryType
) : UserApiType {

    override fun fetchUsers(): Single<HttpSuccessResponse> {
        val httpTransition = HttpTransition(
            verb = HttpVerb.GET,
            url = "${BuildConfig.BASE_URL_API}users"
        )
        return httpRequestFactory.create(httpTransition)
    }
}
