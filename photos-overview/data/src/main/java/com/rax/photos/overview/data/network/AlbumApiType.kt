package com.rax.photos.overview.data.network

import com.rax.core.repository.HttpSuccessResponse
import io.reactivex.rxjava3.core.Single

interface AlbumApiType {
    fun fetchAlbums(): Single<HttpSuccessResponse>
}