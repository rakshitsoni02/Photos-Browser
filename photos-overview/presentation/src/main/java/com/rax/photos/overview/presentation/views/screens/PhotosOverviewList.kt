package com.rax.photos.overview.presentation.views.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rax.photos.overview.domain.entities.PhotoEntity
import com.rax.photos.overview.presentation.views.screens.components.PhotoListItem
import com.rax.ui.components.theme.AppTheme

@Composable
fun PhotosOverviewList(
    entities: List<PhotoEntity>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        item {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        }
        itemsIndexed(
            items = entities,
            key = { _, entity -> entity.id }
        ) { index, photoEntity ->
            PhotosOverviewList(
                photoEntity = photoEntity,
                index = index
            )
        }
    }
}

@Composable
private fun PhotosOverviewList(
    photoEntity: PhotoEntity,
    index: Int
) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        val staggerWidth = if (index % 2 == 0) 72.dp else 16.dp
        Spacer(modifier = Modifier.width(staggerWidth))
        PhotoListItem(
            photoEntity = photoEntity,
            shape = RoundedCornerShape(topStart = 24.dp),
            modifier = Modifier.height(96.dp)
        )
    }
}

@Preview(name = "PhotosOverviewList")
@Composable
private fun PhotosOverviewListPreview() {
    AppTheme {
        PhotosOverviewList(
            entities = samplePhotosList
        )
    }
}
