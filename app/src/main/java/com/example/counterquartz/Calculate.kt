package com.example.counterquartz

interface Calculate {
    fun calculate(value: Int, isPlus: Boolean, bonus: Int = 0)
}