package com.ak.composehotelui.advanced_layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun MyList(modifier: Modifier = Modifier) {

}

@Preview(
    showBackground = true
)
@Composable
private fun MyListPreview() {
    ComposeHotelUITheme {
        MyList()
    }
}