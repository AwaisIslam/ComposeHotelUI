package com.ak.composehotelui.basiclayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun RowColumnDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.size(100.dp)
            .background(Color.Red)
            .weight(1f)
        )
        Box(modifier = Modifier.size(100.dp)
            .background(Color.Green)
            .weight(1f)
        )
        Box(modifier = Modifier.size(100.dp)
            .background(Color.Blue)
            .weight(1f)
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun RomColumnDemoPreview() {
    ComposeHotelUITheme {
        RowColumnDemo()
    }
}