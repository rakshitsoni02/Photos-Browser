package com.rax.ui.components.snackbars

import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppSnackbarHost(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    snackbar: @Composable (SnackbarData) -> Unit = { AppSnackbar(message = it.visuals.message) }
) {
    SnackbarHost(modifier = modifier, hostState = snackbarHostState, snackbar = snackbar)
}
