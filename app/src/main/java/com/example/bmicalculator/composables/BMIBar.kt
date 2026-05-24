package com.example.bmicalculator.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmicalculator.lib.bmiToProgress

@Composable
fun BMIBar(value: Float){
    Row(modifier = Modifier.fillMaxWidth()) {
        val progress = bmiToProgress(value)

        LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier.fillMaxWidth(),
        color = when {
                        value < 18.5f -> Color.Blue
                        value < 25f -> Color.Green
                        value < 30f -> Color.Yellow
                        else -> Color.Red
                    },
        trackColor = ProgressIndicatorDefaults.linearTrackColor,
        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
        )
    }
}

@Preview
@Composable
fun BMIBarPreview(){
    BMIBar(17f)
}

