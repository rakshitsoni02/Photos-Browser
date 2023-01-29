package com.rax.photos.overview.data.repository

import com.rax.photos.overview.data.envelopes.*
import com.rax.photos.overview.data.mappers.AlbumEnvelopeMapper
import com.rax.photos.overview.data.network.AlbumApiType
import com.rax.photos.overview.domain.model.Album
import com.rax.photos.overview.domain.repository.AlbumRepositoryType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@OptIn(ExperimentalStdlibApi::class)
class AlbumRepository @Inject constructor(
    private val apiType: AlbumApiType,
    private val moshi: Moshi
) : AlbumRepositoryType {

    override fun getAlbums(): Single<List<Album>> {
        return apiType.fetchAlbums().map {
            val responseBody = it.body
            val responseEnvelope =
                requireNotNull(moshi.adapter<List<AlbumEnvelope>>().fromJson(responseBody))
            responseEnvelope.map(AlbumEnvelopeMapper::mapFrom)
        }
    }
}