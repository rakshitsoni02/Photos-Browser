package com.rax.photos.overview.data.network

import com.rax.core.BuildConfig
import com.rax.core.repository.HttpRequestFactoryType
import com.rax.core.repository.HttpSuccessResponse
import com.rax.core.repository.HttpTransition
import com.rax.core.repository.HttpVerb
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AlbumApi @Inject constructor(
    private val httpRequestFactory: HttpRequestFactoryType
) : AlbumApiType {

    override fun fetchAlbums(): Single<HttpSuccessResponse> {
        val httpTransition = HttpTransition(
            verb = HttpVerb.GET,
            url = "${BuildConfig.BASE_URL_API}albums"
        )
        return httpRequestFactory.create(httpTransition)
    }
}
