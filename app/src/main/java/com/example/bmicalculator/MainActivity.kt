package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bmicalculator.composables.BMIBar
import com.example.bmicalculator.composables.RadioInput
import com.example.bmicalculator.composables.TextInput
import com.example.bmicalculator.data.classes.BMIForm
import com.example.bmicalculator.data.classes.Gender
import com.example.bmicalculator.lib.bmiEvaluate
import com.example.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var formData by remember { mutableStateOf(BMIForm()) }
            var result by remember { mutableStateOf<Float?>(null) }

            BMICalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        TextInput(
                            input = formData.age?.toString() ?: "",
                            onInputChange = { newValue ->
                                formData = formData.copy(age = newValue.toIntOrNull())
                            },
                            hint = "enter your age",
                            label = "age",
                            modifier = Modifier.padding()
                        )

                        RadioInput(
                            options = Gender.entries,
                            selected = formData.gender,
                            onSelectedChange = { selected ->
                                formData = formData.copy(gender = selected)
                            },
                            label = { it.name },
                        )

                        TextInput(
                            input = formData.height?.toString() ?: "",
                            onInputChange = { newValue ->
                                formData = formData.copy(height = newValue.toIntOrNull())
                            },
                            hint = "enter your height",
                            label = "height",
                            modifier = Modifier.padding()
                        )

                        TextInput(
                            input = formData.weight?.toString() ?: "",
                            onInputChange = { newValue ->
                                formData = formData.copy(weight = newValue.toIntOrNull())
                            },
                            hint = "enter your weight",
                            label = "weight",
                            modifier = Modifier.padding()
                        )

                        Text(text = result?.toString() ?: "0")

                        BMIBar(value = result ?: 0f)

                        Button(
                            onClick = {
                                result = bmiEvaluate(formData)}
                        ) {
                            Text("calculate BMI")
                        }
                    }
                }
            }
        }
    }
}
