package com.rax.photos.overview.presentation.views.factory

import com.rax.photos.overview.domain.entities.PhotoEntity

object PhotoEntityFactory {

    fun create(): PhotoEntity {
        return PhotoEntity(
            id = 1,
            albumTitle = "album title",
            userName = "user name",
            title = "photo title",
            thumbnailUrl = "URL",
        )
    }
}
