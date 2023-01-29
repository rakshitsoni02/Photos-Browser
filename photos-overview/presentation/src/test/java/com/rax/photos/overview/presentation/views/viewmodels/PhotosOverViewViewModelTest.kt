package com.rax.photos.overview.presentation.views.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.rax.core.repository.ErrorEnvelope
import com.rax.core.repository.exceptions.ApiException
import com.rax.photos.overview.domain.usecases.GetPhotosOverviewUseCase
import com.rax.photos.overview.presentation.views.popups.PhotosOverViewPopUp
import com.rax.photos.overview.presentation.views.states.PhotosOverViewViewState
import com.rax.test.getOrAwaitValue
import io.mockk.*
import io.reactivex.rxjava3.core.Single
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PhotosOverViewViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val getPhotos = mockk<GetPhotosOverviewUseCase>(relaxUnitFun = true)

    private val viewModel by lazy {
        PhotosOverViewViewModel(
            getPhotos = getPhotos
        )
    }

    @Test
    fun `GIVEN empty photos WHEN onViewCreated invoked THEN verify correct view state sequences is emitted`() {
        // GIVEN
        val viewStateObserver =
            mockk<Observer<PhotosOverViewViewState>> { every { onChanged(any()) } just Runs }
        viewModel.outputs.viewState.observeForever(viewStateObserver)
        every { getPhotos.invoke(Unit) } returns Single.just(listOf())
        // WHEN
        viewModel.inputs.onViewCreated()
        // THEN
        verify(exactly = 1) {
            getPhotos.invoke(Unit)
        }
        verifySequence {
            viewStateObserver.onChanged(PhotosOverViewViewState.Loading)
            viewStateObserver.onChanged(PhotosOverViewViewState.PhotoDetails(listOf()))
        }
    }

    @Test
    fun `GIVEN data error WHEN onViewCreated invoked THEN verify correct view state sequences is emitted`() {
        // GIVEN
        val viewStateObserver =
            mockk<Observer<PhotosOverViewViewState>> { every { onChanged(any()) } just Runs }
        viewModel.outputs.viewState.observeForever(viewStateObserver)
        val error = badRequestException()
        coEvery { getPhotos.invoke(Unit) } returns Single.error(error)
        // WHEN
        viewModel.inputs.onViewCreated()
        // THEN
        verify(exactly = 1) {
            getPhotos.invoke(Unit)
        }
        assertEquals(
            PhotosOverViewPopUp.Snackbar(
                message = "bad request"
            ), viewModel.outputs.popUp.getOrAwaitValue()
        )
        verifySequence {
            viewStateObserver.onChanged(PhotosOverViewViewState.Loading)
            viewStateObserver.onChanged(PhotosOverViewViewState.Error)
        }
    }

    private fun badRequestException(): ApiException {
        val envelope = ErrorEnvelope(message = "bad request")
        val requestId = "request_id"
        return ApiException(400, requestId, envelope)
    }
}