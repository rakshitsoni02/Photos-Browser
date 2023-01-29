package com.rax.photos.overview.presentation.views.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rax.photos.overview.domain.entities.PhotoEntity
import com.rax.photos.overview.presentation.views.screens.samplePhotosList
import com.rax.ui.components.image.NetworkImage
import com.rax.ui.components.theme.AppTheme
import com.rax.ui.components.theme.BlueGrey50

@Composable
fun PhotoListItem(
    photoEntity: PhotoEntity,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = AppTheme.elevations.card
) {
    Surface(
        tonalElevation = elevation,
        shape = shape,
        modifier = modifier
    ) {
        Row {
            NetworkImage(
                url = photoEntity.thumbnailUrl,
                contentDescription = null,
                modifier = Modifier.aspectRatio(1f)
            )
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 8.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
            ) {
                Text(
                    text = photoEntity.title.uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = photoEntity.albumTitle,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = photoEntity.userName,
                    color = BlueGrey50,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.Start)
                )
            }
        }
    }
}

@Preview(name = "Photo list item")
@Composable
private fun PhotoListItemPreview() {
    Column {
        AppTheme(isDarkTheme = true) {
            PhotoListItem(
                photoEntity = samplePhotosList.first()
            )
        }
        AppTheme(isDarkTheme = false) {
            PhotoListItem(
                photoEntity = samplePhotosList.first()
            )
        }
    }
}
