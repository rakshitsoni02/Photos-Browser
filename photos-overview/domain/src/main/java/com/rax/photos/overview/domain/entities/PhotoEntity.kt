package com.rax.photos.overview.domain.entities

data class PhotoEntity(
    val id: Int,
    val title: String,
    val thumbnailUrl: String,
    val albumTitle: String,
    val userName: String,
)