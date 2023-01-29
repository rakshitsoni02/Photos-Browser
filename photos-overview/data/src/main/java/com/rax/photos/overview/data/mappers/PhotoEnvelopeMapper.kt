package com.rax.photos.overview.data.mappers

import com.rax.photos.overview.data.envelopes.PhotoEnvelope
import com.rax.photos.overview.domain.model.Photo

object PhotoEnvelopeMapper {

    fun mapFrom(from: PhotoEnvelope): Photo {
        return Photo(
            id = from.id,
            title = from.title,
            albumId = from.albumId,
            photoUrl = from.photoUrl,
            thumbnailUrl = from.thumbnailUrl,
        )
    }
}