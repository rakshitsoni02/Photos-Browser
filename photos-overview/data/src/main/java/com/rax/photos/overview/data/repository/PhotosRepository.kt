package com.rax.photos.overview.data.repository

import com.rax.photos.overview.data.envelopes.*
import com.rax.photos.overview.data.mappers.PhotoEnvelopeMapper
import com.rax.photos.overview.data.network.PhotosApiType
import com.rax.photos.overview.domain.model.Photo
import com.rax.photos.overview.domain.repository.PhotosRepositoryType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@OptIn(ExperimentalStdlibApi::class)
class PhotosRepository @Inject constructor(
    private val apiType: PhotosApiType,
    private val moshi: Moshi
) : PhotosRepositoryType {

    override fun getPhotos(): Single<List<Photo>> {
        return apiType.fetchPhotos().map {
            val responseBody = it.body
            val responseEnvelope =
                requireNotNull(moshi.adapter<List<PhotoEnvelope>>().fromJson(responseBody))
            responseEnvelope.map(PhotoEnvelopeMapper::mapFrom)
        }
    }
}
