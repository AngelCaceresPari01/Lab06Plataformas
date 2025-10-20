package com.example.lab05

import android.graphics.Color

data class Ambiente(
    val nombre: String,
    val x1: Float,
    val y1: Float,
    val x2: Float,
    val y2: Float,
    val color: Int
) {
    val colorHex: String
        get() = String.format("#%06X", 0xFFFFFF and color)

    fun area(): Float = (x2 - x1) * (y2 - y1) / 10000 // área aprox en m²
}
