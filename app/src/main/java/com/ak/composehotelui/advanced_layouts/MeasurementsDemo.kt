package com.ak.composehotelui.advanced_layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun MeasurementsDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Red)
            .padding(16.dp)
    ) {
        Text(
            text = "This is a text",
            modifier = modifier.background(Color.Yellow)
        )
        Text(
            text = "This is an other text",
            modifier = modifier.background(Color.Green)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun MeasurementsDemoPreview() {
    ComposeHotelUITheme {
        MeasurementsDemo()
    }
}