package com.rax.photos.overview.presentation.views.viewmodels.outputs

import androidx.lifecycle.LiveData
import com.rax.photos.overview.presentation.views.popups.PhotosOverViewPopUp
import com.rax.photos.overview.presentation.views.states.PhotosOverViewViewState

interface PhotosOverViewOutputs {
    val popUp: LiveData<PhotosOverViewPopUp?>
    val viewState: LiveData<PhotosOverViewViewState>
}
