package com.rax.photos.overview.domain.usecases

import com.rax.core.logging.Logger
import com.rax.core.usecase.SingleUseCase
import com.rax.core.usecase.UseCaseScheduler
import com.rax.photos.overview.domain.entities.PhotoEntity
import com.rax.photos.overview.domain.mappers.PhotoEntityMapper
import com.rax.photos.overview.domain.repository.AlbumRepositoryType
import com.rax.photos.overview.domain.repository.PhotosRepositoryType
import com.rax.photos.overview.domain.repository.UserRepositoryType
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPhotosOverviewUseCase @Inject constructor(
    private val photosRepositoryType: PhotosRepositoryType,
    private val albumRepositoryType: AlbumRepositoryType,
    private val userRepositoryType: UserRepositoryType,
    useCaseScheduler: UseCaseScheduler? = null, logger: Logger? = null
) : SingleUseCase<List<PhotoEntity>, Unit>(useCaseScheduler, logger) {

    override fun build(param: Unit): Single<List<PhotoEntity>> {
        return Single.zip(
            photosRepositoryType.getPhotos().map { photos ->
                photos.distinctBy { it.albumId }
            },
            albumRepositoryType.getAlbums().map { albums ->
                albums.associateBy({ it.id }, { it })
            },
            userRepositoryType.getUsers().map { users ->
                users.associateBy({ it.id }, { it })
            }
        ) { photos, albums, users ->
            photos.map { photo ->
                val album = requireNotNull(albums[photo.albumId])
                val user = requireNotNull(users[album.userId])
                PhotoEntityMapper.mapFrom(
                    photo = photo,
                    album = album,
                    user = user
                )
            }
        }
    }
}
