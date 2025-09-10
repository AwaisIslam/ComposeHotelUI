package com.ak.composehotelui.basiclayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun LazyListDemo(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier.fillMaxSize()
    ) {
        items(100){i->
            Text("Hello World $i")
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun LazyListDemoPreview() {
    ComposeHotelUITheme {
        LazyListDemo(Modifier)
    }
}