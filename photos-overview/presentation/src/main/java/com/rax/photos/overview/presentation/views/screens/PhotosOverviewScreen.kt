package com.rax.photos.overview.presentation.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rax.photos.overview.domain.entities.PhotoEntity
import com.rax.photos.overview.presentation.R
import com.rax.photos.overview.presentation.views.popups.PhotosOverViewPopUp
import com.rax.photos.overview.presentation.views.screens.components.PopUp
import com.rax.photos.overview.presentation.views.states.PhotosOverViewViewState
import com.rax.photos.overview.presentation.views.viewmodels.PhotosOverViewViewModel
import com.rax.ui.components.snackbars.AppSnackbarHost
import com.rax.ui.components.theme.AppTheme
import com.rax.ui.components.theme.Grey80

@Composable
fun PhotosOverviewScreen(viewModel: PhotosOverViewViewModel) {
    val viewState by viewModel.outputs.viewState.observeAsState()
    val popUp by viewModel.outputs.popUp.observeAsState()

    PhotosOverviewScreen(
        viewState = viewState,
        popUp = popUp,
        onPopUpDismissed = viewModel.inputs::onPopUpDismissed
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhotosOverviewScreen(
    viewState: PhotosOverViewViewState?,
    popUp: PhotosOverViewPopUp?,
    onPopUpDismissed: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { AppSnackbarHost(snackbarHostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.photo_overview).uppercase())
                },
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (viewState) {
                PhotosOverViewViewState.Loading -> LoadingState()
                PhotosOverViewViewState.Error -> ErrorState()
                is PhotosOverViewViewState.PhotoDetails -> PhotosOverviewList(entities = viewState.photos)
                else -> {
                    //no-op
                }
            }
        }
        PopUp(
            popUp = popUp,
            snackbarHostState = snackbarHostState,
            onPopUpDismissed = onPopUpDismissed
        )
    }
}


@Composable
private fun LoadingState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun ErrorState() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(56.dp),
            painter = painterResource(id = com.rax.shared.ui.components.R.drawable.ic_error_48x48),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
        )
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = stringResource(id = R.string.error_text),
            color = Grey80,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun PhotosOverviewScreenPreView() {
    AppTheme {
        PhotosOverviewScreen(
            viewState = PhotosOverViewViewState.PhotoDetails(samplePhotosList),
            onPopUpDismissed = {
                //no-op
            },
            popUp = PhotosOverViewPopUp.Snackbar("Mr. Error Test")
        )
    }
}

val samplePhotosList = listOf(
    PhotoEntity(
        id = 1,
        title = "Test name",
        thumbnailUrl = "https://via.placeholder.com/150/d83e34",
        albumTitle = "Album name",
        userName = "User name"
    ),
    PhotoEntity(
        id = 2,
        title = "Test name 2",
        thumbnailUrl = "https://via.placeholder.com/150/d83e34",
        albumTitle = "Album name2",
        userName = "User name 2"
    ),
    PhotoEntity(
        id = 3,
        title = "Test name 3",
        thumbnailUrl = "https://via.placeholder.com/150/d83e34",
        albumTitle = "Album name 3",
        userName = "User name 3"
    ),
)
