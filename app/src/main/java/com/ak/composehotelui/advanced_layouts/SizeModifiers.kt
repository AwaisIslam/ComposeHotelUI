package com.ak.composehotelui.advanced_layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.advanced_layouts.utility.printConstraints
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun SizeModifiersDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.height(100.dp)
        .fillMaxWidth()
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .printConstraints("Before 1. fillMaxWidth")
                .fillMaxWidth(0.5f)
                .printConstraints("After 1. fillMaxWidth")
                .background(Color.Yellow)
        )
        Box(
            modifier = Modifier
                .height(100.dp)
                .printConstraints("Before 2. fillMaxWidth")
                .fillMaxWidth(0.5f)
                .printConstraints("After 2. fillMaxWidth")
                .background(Color.Green)
        )
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