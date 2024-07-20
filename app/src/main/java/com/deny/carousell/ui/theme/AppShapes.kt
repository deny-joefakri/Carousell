package com.deny.carousell.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

private val Shapes = Shapes(
    // Custom shapes here
    RoundedCornerShape(4.dp)
)

internal val LocalAppShapes = staticCompositionLocalOf { Shapes }
