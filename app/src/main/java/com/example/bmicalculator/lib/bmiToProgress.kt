package com.example.bmicalculator.lib

fun bmiToProgress(bmi: Float): Float {
    val minBMI = 10f
    val maxBMI = 40f

    return ((bmi - minBMI) / (maxBMI - minBMI))
        .coerceIn(0f, 1f)
}