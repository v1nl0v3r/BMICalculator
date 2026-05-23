package com.example.bmicalculator.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> RadioInput(
    options: List<T>,
    selected: T,
    onSelectedChange: (T) -> Unit,
    label: (T) -> String
) {
    Column {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = option == selected,
                    onClick = { onSelectedChange(option) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = label(option))
            }
        }
    }
}