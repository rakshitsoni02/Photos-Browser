package com.rax.photos.overview.presentation.di

import com.rax.photos.overview.data.network.*
import com.rax.photos.overview.data.repository.AlbumRepository
import com.rax.photos.overview.data.repository.PhotosRepository
import com.rax.photos.overview.data.repository.UserRepository
import com.rax.photos.overview.domain.repository.AlbumRepositoryType
import com.rax.photos.overview.domain.repository.PhotosRepositoryType
import com.rax.photos.overview.domain.repository.UserRepositoryType
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

object PhotosOverViewModule {
    @Module
    @InstallIn(SingletonComponent::class)
    interface PhotosRepositoryModule {
        @Binds
        fun bindPhotosRepository(impl: PhotosRepository): PhotosRepositoryType
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AlbumRepositoryModule {
        @Binds
        fun bindAlbumRepository(impl: AlbumRepository): AlbumRepositoryType
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface UserRepositoryModule {
        @Binds
        fun bindUserRepository(impl: UserRepository): UserRepositoryType
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface PhotosApiTypeModule {
        @Binds
        fun bindPhotosApi(impl: PhotosApi): PhotosApiType
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface UserApiTypeModule {
        @Binds
        fun bindPhotosApi(impl: UserApi): UserApiType
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AlbumApiTypeModule {
        @Binds
        fun bindPhotosApi(impl: AlbumApi): AlbumApiType
    }
}

