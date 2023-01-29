package com.rax.photos.overview.presentation.views

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rax.photos.overview.presentation.views.screens.PhotosOverviewScreen
import com.rax.photos.overview.presentation.views.viewmodels.PhotosOverViewViewModel
import com.rax.ui.components.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosOverviewActivity : AppCompatActivity() {

    private val viewModel: PhotosOverViewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                PhotosOverviewScreen(viewModel)
            }
        }
        viewModel.inputs.onViewCreated()
    }
}