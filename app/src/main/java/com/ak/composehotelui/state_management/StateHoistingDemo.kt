package com.ak.composehotelui.state_management

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun StateHoistingDemo(modifier: Modifier = Modifier) {
// remember is used to cache the value in composable
    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Counter(
            counter = counter,
            onCounterButtonClick = {
                counter += 2
            }
        )
        Button(
            onClick = {
                counter = 0
            }
        ) {
            Text(text = "Reset Counter")
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun StateHoistingPreview() {
    ComposeHotelUITheme {
        StateHoistingDemo()
    }
}