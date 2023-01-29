package com.rax.ui.components.snackbars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rax.ui.components.theme.AppTheme
import com.rax.ui.components.theme.Grey20

@Composable
fun AppSnackbar(
    message: String,
    modifier: Modifier = Modifier
) {
    val snackbarText = message.ifEmpty { "something went wrong" }
    Snackbar(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        content = {
            Text(
                text = snackbarText
            )
        },
        contentColor = Grey20,
        shape = RoundedCornerShape(6.dp)
    )
}

@Preview
@Composable
private fun AppSnackbarPreview() {
    AppTheme {
        Column {
            AppSnackbar(
                "Everything went great"
            )
            AppSnackbar(
                "First line\nSecond line"
            )
        }
    }
}
