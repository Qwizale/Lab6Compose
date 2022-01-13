package com.example.calc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.calc.mvi.CalcViewModel
import com.example.calc.mvi.CalcViewModelFactory
import com.example.calc.mvi.State
import com.example.calc.ui.theme.CalcTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

class MainActivity : ComponentActivity() {

    private lateinit var viewModelFactory: CalcViewModelFactory
    private lateinit var viewModel: CalcViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val _state = MutableStateFlow(State())

        viewModelFactory = CalcViewModelFactory(_state)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CalcViewModel::class.java)

        setContent {
            CalcTheme {
                val state by viewModel.state.collectAsState()

                Calculator(state = state, performIntent = viewModel::performIntent)

            }
        }
    }

    @Composable
    fun Calculator(state: State, performIntent: (Intent) -> Unit) {
        Scaffold(modifier = Modifier.fillMaxSize()) {

            Column(modifier = Modifier.fillMaxSize()) {

                Box(modifier = Modifier.fillMaxWidth()) {

                    Button(
                        onClick = { performIntent(Intent.ClearValue) },
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "X",
                            fontSize = 56.sp,
                        )
                    }

                    Text(
                        text = state.mathExpression,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterStart)
                            .padding(16.dp, end = 88.dp)
                            .height(56.dp)
                    )
                }

                Text(
                    text = "${stringResource(id = R.string.answer)} ${state.answer}",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(56.dp)
                )

                NumberLayout(performIntent = performIntent)

            }
        }
    }
}

