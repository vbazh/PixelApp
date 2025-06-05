package com.example.myapplication.android.render

import Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

private val DefaultColor = Colors.Transparent

@Composable
fun ProjectRender(pixels: List<List<Int>>, colorMap: Map<Int, Color>, modifier: Modifier = Modifier) {

    val maxPixelWidth = pixels.first().size
    println("maxPixelWidth = $maxPixelWidth")
    val pixelSize = LocalConfiguration.current.screenWidthDp / maxPixelWidth

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Colors.ViennaBackground),
        contentAlignment = Alignment.Center
    ) {
        Column {
            pixels.forEach { pixelsRow ->
                Row {
                    pixelsRow.forEach { pixel ->
                        Box(
                            modifier = Modifier
                                .size(pixelSize.dp)
                                .background(pixel.toColor(colorMap))
                        )
                    }
                }
            }
        }
    }
}

private fun Int.toColor(colorMap: Map<Int, Color>): Color {
    return colorMap[this] ?: DefaultColor
}