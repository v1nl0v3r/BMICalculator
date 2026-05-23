package com.example.bmicalculator.lib

import com.example.bmicalculator.data.classes.BMIForm

fun bmiEvaluate(data: BMIForm): Float{
    val w = data.weight ?: return 0f
    val h = data.height ?: return 0f
    if (h == 0) return 0f

    return w / (h * h).toFloat()
}