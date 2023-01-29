package com.rax.photos.overview.data.repository

import com.rax.photos.overview.data.network.PhotosApiType
import com.rax.test.repositories.HttpSuccessResponseFactory
import com.squareup.moshi.Moshi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test

class PhotosRepositoryTest {

    private val photoApi: PhotosApiType = mockk(relaxUnitFun = true)
    private val moshi = Moshi.Builder()
        .build()

    private lateinit var repository: PhotosRepository

    @Before
    fun setUp() {
        repository = PhotosRepository(
            photoApi,
            moshi
        )
    }

    @Test
    fun `when fetchPhotos invoked then verify expected network api`() {
        // GIVEN
        val jsonFile = ClassLoader.getSystemResource("photos_list.json")
        val json = jsonFile.readText()
        coEvery { photoApi.fetchPhotos() } returns Single.just(
            HttpSuccessResponseFactory.create(
                body = json
            )
        )
        // WHEN
        repository.getPhotos()
        // THEN
        coVerify { photoApi.fetchPhotos() }
    }
}
