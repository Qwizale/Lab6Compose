package com.example.calc

sealed class Intent {
    class ChangeValue(val value: String) : Intent()
    object ClearValue : Intent()
    object CalculateValue : Intent()
}
