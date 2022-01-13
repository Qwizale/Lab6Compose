package com.example.calc.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.calc.Intent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.NullPointerException

class CalcViewModel(
    val state: MutableStateFlow<State>
) : ViewModel() {

    private var _state = State()
    private val operators = listOf("+", "-", "*", "/")

    fun performIntent(intent: Intent) {
        when (intent) {
            is Intent.ChangeValue -> {
                viewModelScope.launch {
                    if (validate(_state.mathExpression, intent.value)) {
                        val newValue = if (operators.contains(intent.value)) {
                            if (state.value.mathExpression.isNotEmpty()) {
                                " ${intent.value} "
                            } else {
                                intent.value
                            }
                        } else {
                            intent.value
                        }
                        _state = _state.copy(mathExpression = _state.mathExpression + newValue)
                        state.value = _state
                    }
                }

            }
            is Intent.ClearValue -> {
                viewModelScope.launch {
                    _state = _state.copy(mathExpression = "")
                    state.value = _state
                }
            }
            is Intent.CalculateValue -> {
                val result = calculate(state.value.mathExpression)
                viewModelScope.launch {
                    _state = _state.copy(answer = result.toString())
                    state.value = _state
                }
            }
        }
    }

    private fun validate(expression: String, char: String): Boolean {

        if (expression.isEmpty() || expression.lastIndex == 0) return true

        val isOperator = isOperator(char = char)
        val isLastOperator = operators.contains(expression[expression.lastIndex - 1].toString())

        return when {
            isOperator && isLastOperator && expression.lastIndex < 2 -> true
            isOperator && isLastOperator -> false
            else -> true
        }
    }

    private fun isOperator(char: String) = operators.contains(char)

    private fun calculate(expression: String) : Double {

        fun getResult(operator: String, x: Double, y: Double): Double = when (operator) {
            "+" -> x + y
            "-" -> x - y
            "*" -> x * y
            "/" -> x / y
            else -> (0 / 0).toDouble()
        }

        val numbersAndOperators = expression.split(" ")

        var result = 0.0

        try {


            numbersAndOperators.forEachIndexed { index, char ->
                if (isOperator(char)) {
                    result = if (index == 1) {
                        getResult(
                            operator = char,
                            x = numbersAndOperators[index - 1].toDouble(),
                            y = numbersAndOperators[index + 1].toDouble(),
                        )
                    } else {
                        getResult(
                            operator = char,
                            x = result,
                            y = numbersAndOperators[index + 1].toDouble(),
                        )
                    }
                }
            }
        } catch (e: Exception) {
            result = Double.NaN
        }

        return result
    }
}

class CalcViewModelFactory(private val state: MutableStateFlow<State>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalcViewModel::class.java)) {
            return CalcViewModel(state) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}