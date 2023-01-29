package com.rax.photos.overview.presentation.views.popups

sealed interface PhotosOverViewPopUp {

    data class Snackbar(val message: String) : PhotosOverViewPopUp
}