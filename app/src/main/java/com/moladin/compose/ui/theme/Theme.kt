package com.moladin.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//TODO: 0.a Ganti warna tema dark
private val DarkColorPalette = darkColors(
    primary = Purple200, //action bar color
    primaryVariant = Purple700, //status bar color
    secondary = Teal200 // tint background-color pada fab
)

//TODO: 0.b Ganti warna tema light
private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,

    /* Other default colors to override
    background = Color.White, //background app
    surface = Color.White, //don't know
    onPrimary = Color.White, //action bar text / tint image color
    onSecondary = Color.Black, //tint color pada fab
    onBackground = Color.Black, //text color
    onSurface = Color.Black, //color divider
    */
)

@Composable
fun MoladinJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}