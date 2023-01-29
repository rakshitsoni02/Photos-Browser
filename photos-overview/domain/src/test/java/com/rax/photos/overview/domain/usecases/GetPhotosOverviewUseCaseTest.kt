package com.rax.photos.overview.domain.usecases

import com.rax.photos.overview.domain.repository.AlbumRepositoryType
import com.rax.photos.overview.domain.repository.PhotosRepositoryType
import com.rax.photos.overview.domain.repository.UserRepositoryType
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import org.junit.Test

class GetPhotosOverviewUseCaseTest {

    private val photosRepositoryType: PhotosRepositoryType = mockk(relaxUnitFun = true)
    private val albumRepositoryType: AlbumRepositoryType = mockk(relaxUnitFun = true)
    private val userRepositoryType: UserRepositoryType = mockk(relaxUnitFun = true)

    private val useCase: GetPhotosOverviewUseCase by lazy {
        GetPhotosOverviewUseCase(
            photosRepositoryType = photosRepositoryType,
            userRepositoryType = userRepositoryType,
            albumRepositoryType = albumRepositoryType
        )
    }

    @Test
    fun `WHEN invoked THEN verify expected repository being called`() {
        // GIVEN
        every { userRepositoryType.getUsers() } returns Single.just(listOf())
        every { photosRepositoryType.getPhotos() } returns Single.just(listOf())
        every { albumRepositoryType.getAlbums() } returns Single.just(listOf())
        // WHEN
        useCase.invoke(Unit)
        // THEN
        verify {
            photosRepositoryType.getPhotos()
            albumRepositoryType.getAlbums()
            userRepositoryType.getUsers()
        }
    }
}