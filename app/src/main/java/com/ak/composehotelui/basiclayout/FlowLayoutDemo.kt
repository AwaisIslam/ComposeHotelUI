package com.ak.composehotelui.basiclayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemo(modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    FlowRow(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        maxLines = if (expanded) Int.MAX_VALUE else 4,
        overflow = FlowRowOverflow.expandOrCollapseIndicator(
            expandIndicator = {
                IconButton(onClick = {
                    expanded = true
                }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand"
                    )
                }
            },
            collapseIndicator = {
                IconButton(onClick = { expanded = false }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Collapse"
                    )
                }
            }
        )
    ) {
        for (i in 1..30) {
            AssistChip(
                onClick = {},
                {
                    Text(text = "Item: $i")
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun FlowDemoPreivew() {
    ComposeHotelUITheme {
        FlowLayoutDemo(Modifier)
    }
}