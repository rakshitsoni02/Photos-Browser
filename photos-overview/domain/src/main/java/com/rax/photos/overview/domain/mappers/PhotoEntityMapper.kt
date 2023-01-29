package com.rax.photos.overview.domain.mappers

import com.rax.photos.overview.domain.entities.PhotoEntity
import com.rax.photos.overview.domain.model.Album
import com.rax.photos.overview.domain.model.Photo
import com.rax.photos.overview.domain.model.User

object PhotoEntityMapper {

    fun mapFrom(photo: Photo, album: Album, user: User): PhotoEntity {
        return PhotoEntity(
            thumbnailUrl = photo.thumbnailUrl,
            title = photo.title,
            userName = user.name,
            albumTitle = album.title,
            id = photo.id
        )
    }
}