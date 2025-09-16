package com.ak.composehotelui.advanced_layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.advanced_layouts.utility.printConstraints
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun SizeModifiersDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .printConstraints("Before 1. fillMaxWidth")
                .requiredWidth(300.dp)
                .background(Color.Green)
                .wrapContentWidth(
                    align = Alignment.CenterHorizontally
                )
                .printConstraints("After 1. fillMaxWidth")
                .background(Color.Yellow)
        ) {
            Text("Hello World")
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun SizeModifiersPreview() {
    ComposeHotelUITheme {
        SizeModifiersDemo()
    }
}