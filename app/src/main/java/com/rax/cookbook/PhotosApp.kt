package com.rax.cookbook

import coil.ImageLoader
import coil.ImageLoaderFactory
import com.rax.core.BaseApplication
import com.rax.ui.components.image.UnsplashSizingInterceptor
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PhotosApp : BaseApplication(), ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .components {
                add(UnsplashSizingInterceptor)
            }
            .respectCacheHeaders(false)
            .build()
    }
}