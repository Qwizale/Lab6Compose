package com.example.calc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calc.mvi.State

@Composable
fun NumberLayout(performIntent: (Intent) -> Unit) {

    val buttonSize = 32.sp

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {

        Button(
            onClick = { performIntent(Intent.ChangeValue("1")) },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = "1",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("2")) },
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "2",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("3")) },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Text(
                text = "3",
                fontSize = buttonSize,
            )
        }

    }

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {

        Button(
            onClick = { performIntent(Intent.ChangeValue("4")) },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = "4",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("5")) },
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "5",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("6")) },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Text(
                text = "6",
                fontSize = buttonSize,
            )
        }

    }

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {

        Button(
            onClick = { performIntent(Intent.ChangeValue("7")) },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = "7",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("8")) },
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "8",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("9")) },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Text(
                text = "9",
                fontSize = buttonSize,
            )
        }

    }

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {

        Button(
            onClick = { performIntent(Intent.ChangeValue("0")) },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = "0",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("+")) },
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "+",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("-")) },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Text(
                text = "-",
                fontSize = buttonSize,
            )
        }

    }

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {

        Button(
            onClick = { performIntent(Intent.ChangeValue("*")) },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = "*",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue("/")) },
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "/",
                fontSize = buttonSize,
            )
        }

        Button(
            onClick = { performIntent(Intent.ChangeValue(".")) },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Text(
                text = ".",
                fontSize = buttonSize,
            )
        }

    }

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {

        Button(
            onClick = { performIntent(Intent.CalculateValue) },
            modifier = Modifier
                .align(Alignment.CenterStart)
        ) {
            Text(
                text = "=",
                fontSize = buttonSize,
            )
        }
    }
}