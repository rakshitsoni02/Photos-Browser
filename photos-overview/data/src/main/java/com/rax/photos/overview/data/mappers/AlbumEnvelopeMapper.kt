package com.rax.photos.overview.data.mappers

import com.rax.photos.overview.data.envelopes.AlbumEnvelope
import com.rax.photos.overview.domain.model.Album

object AlbumEnvelopeMapper {

    fun mapFrom(from: AlbumEnvelope): Album {
        return Album(
            id = from.id,
            title = from.title,
            userId = from.userId
        )
    }
}