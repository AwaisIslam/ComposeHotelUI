package com.ak.composehotelui.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun CanvasModifiers(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
            .background(Color.Yellow)
            .drawWithContent{
                drawCircle(
                    color = Color.Red
                )
                drawContent()
                drawCircle(
                    color = Color.Blue,
                    radius = 10.dp.toPx()
                )
            }
            /*.drawBehind{
                drawCircle(
                    color = Color.Red
                )
            }*/,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "I am Circle",
            color = Color.White
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun CanvasModifiersPreview() {
    ComposeHotelUITheme {
        CanvasModifiers()
    }
}