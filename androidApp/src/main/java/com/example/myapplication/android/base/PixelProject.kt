package com.example.myapplication.android.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.myapplication.android.render.ProjectRender

abstract class PixelProject(
    private val answer: List<List<Int>>
) {
    abstract val colorMap: Map<Int, Color>
    abstract val pixels: List<List<Int>>

    @Composable
    abstract fun Preview()

    @Composable
    fun CurrentPreview() {
        ProjectRender(
            pixels = pixels,
            colorMap = colorMap
        )
    }

    @Composable
    fun ResultPreview() {
        ProjectRender(
            pixels = answer,
            colorMap = colorMap
        )
    }
}
