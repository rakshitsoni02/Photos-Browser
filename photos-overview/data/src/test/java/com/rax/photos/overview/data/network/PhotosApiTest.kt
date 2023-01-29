package com.rax.photos.overview.data.network

import com.rax.core.repository.HttpRequestFactoryType
import com.rax.core.repository.HttpTransition
import com.rax.core.repository.HttpVerb
import com.rax.test.BuildConfig
import com.rax.test.repositories.HttpSuccessResponseFactory
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test

class PhotosApiTest {

    private val requestFactory: HttpRequestFactoryType = mockk(relaxUnitFun = true)
    private val successResponse = HttpSuccessResponseFactory.create()

    private lateinit var api: PhotosApi

    @Before
    fun setUp() {
        api = PhotosApi(requestFactory)
    }

    @Test
    fun `WHEN fetchPhotos invoked THEN verify expected GET request`() {
        // GIVEN
        val expectedTransition = HttpTransition(
            verb = HttpVerb.GET,
            url = "${BuildConfig.BASE_URL_API}photos"
        )
        coEvery { requestFactory.create(transition = expectedTransition) } returns Single.just(
            successResponse
        )
        // WHEN
        api.fetchPhotos()
        // THEN
        coVerify { requestFactory.create(transition = expectedTransition) }
    }
}
