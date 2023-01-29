package com.rax.photos.overview.domain.repository

import com.rax.photos.overview.domain.model.Album
import io.reactivex.rxjava3.core.Single

interface AlbumRepositoryType {
    fun getAlbums(): Single<List<Album>>
}