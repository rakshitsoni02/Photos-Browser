package com.rax.photos.overview.presentation.views.states

import com.rax.photos.overview.domain.entities.PhotoEntity

sealed interface PhotosOverViewViewState {

    object Loading : PhotosOverViewViewState

    object Error : PhotosOverViewViewState

    data class PhotoDetails(val photos: List<PhotoEntity>) : PhotosOverViewViewState
}