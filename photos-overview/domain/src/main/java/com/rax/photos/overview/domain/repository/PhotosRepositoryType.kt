package com.rax.photos.overview.domain.repository

import com.rax.photos.overview.domain.model.Photo
import io.reactivex.rxjava3.core.Single

interface PhotosRepositoryType {
    fun getPhotos(): Single<List<Photo>>
}