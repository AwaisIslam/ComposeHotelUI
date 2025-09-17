package com.ak.composehotelui.advanced_layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun IntrinsicSizeDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Option 1, This is a text",
            )
            Checkbox(
                checked = true,
                onCheckedChange = {}
            )
        }

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Option 1, This is a longer text",
            )
            Checkbox(
                checked = true,
                onCheckedChange = {}
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun IntrinsicSizePreview() {
    ComposeHotelUITheme {
        IntrinsicSizeDemo()
    }
}