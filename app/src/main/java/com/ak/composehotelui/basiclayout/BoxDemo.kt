package com.ak.composehotelui.basiclayout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    Box (modifier = Modifier.size(200.dp),
        contentAlignment = Alignment.BottomCenter
    ){

        Text(
            modifier = Modifier.align(Alignment.TopStart),
            text = "Hello World!"
        )
        Text("What's up")
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun BoxDemoPreview() {
    ComposeHotelUITheme {
        BoxDemo()
    }
}