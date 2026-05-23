package com.example.bmicalculator.composables

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmicalculator.ui.theme.BMICalculatorTheme

@Composable
fun TextInput(
    input: String,
    onInputChange:(String) -> Unit,
    hint: String, label: String,
    modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        TextField(
            value = input,
            onValueChange = { newValue ->
                if (newValue.all { it.isDigit() }) {
                    onInputChange(newValue)
                }
            },
            label = {
                Text(text = label)
            },
            placeholder = {
                Text(text = hint)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TextInputPreview() {
    BMICalculatorTheme {
        TextInput(
            input = "",
            onInputChange = { newInput -> },
            hint = "enter your age",
            label= "age",
            modifier = Modifier.padding()
        )
    }
}