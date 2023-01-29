package com.rax.ui.components.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Elevations(val card: Dp = 3.dp)

internal val LocalElevations = staticCompositionLocalOf { Elevations() }
