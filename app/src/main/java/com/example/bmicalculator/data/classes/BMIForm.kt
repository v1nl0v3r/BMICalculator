package com.example.bmicalculator.data.classes
enum class Gender{
    MALE,
    FEMALE
}

data class BMIForm (
    val age: Int? = null,
    val gender: Gender = Gender.MALE,
    val height: Int? = null,
    val weight: Int? = null
)