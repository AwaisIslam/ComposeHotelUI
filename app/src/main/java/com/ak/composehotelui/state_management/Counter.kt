package com.ak.composehotelui.state_management

import androidx.compose.foundation.layout.Box
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
fun Counter(
    counter: Int,
    onCounterButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier,
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {
                onCounterButtonClick
            }
        ) {
            Text(text = "Count $counter")
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CounterPreview() {
    ComposeHotelUITheme {
        Counter(
            counter = 0,
            onCounterButtonClick = {}
        )
    }
}