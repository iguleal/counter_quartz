package com.example.counterquartz

interface Calculate {
    fun calculate(value: Int, bonus: Int = 0)
    fun hideKeyboard()
}