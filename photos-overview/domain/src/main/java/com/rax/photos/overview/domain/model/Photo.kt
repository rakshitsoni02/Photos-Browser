package com.rax.photos.overview.domain.model

data class Photo(
    val id: Int,
    val title: String,
    val thumbnailUrl: String,
    val photoUrl: String,
    val albumId: Int,
)