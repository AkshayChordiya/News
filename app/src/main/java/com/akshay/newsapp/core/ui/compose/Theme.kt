package com.akshay.newsapp.core.ui.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
        primary = colorPrimary,
        primaryVariant = colorPrimaryDark,
        secondary = colorAccent
)

private val LightColorPalette = lightColors(
        primary = colorPrimary,
        primaryVariant = colorPrimaryDark,
        secondary = colorAccent
)

@Composable
fun NewsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            shapes = shapes,
            content = content
    )
}