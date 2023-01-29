package com.rax.photos.overview.presentation.views.screens.components

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.rax.photos.overview.presentation.views.popups.PhotosOverViewPopUp

@Composable
fun PopUp(
    popUp: PhotosOverViewPopUp?,
    snackbarHostState: SnackbarHostState,
    onPopUpDismissed: () -> Unit
) {
    when (popUp) {
        is PhotosOverViewPopUp.Snackbar -> {
            LaunchedEffect(snackbarHostState) {
                if (snackbarHostState.showSnackbar(popUp.message) == SnackbarResult.Dismissed) {
                    onPopUpDismissed.invoke()
                } else {
                    // no-op
                }
            }
        }
        else -> {
            // no-op
        }
    }
}