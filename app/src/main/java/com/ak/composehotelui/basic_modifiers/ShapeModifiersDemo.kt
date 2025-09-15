package com.ak.composehotelui.basic_modifiers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.R
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun ShapeModifierDemo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.kirmit),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .background(Color.Cyan)
            .size(200.dp)
            .clip(StarShape)
    )
}

data object TriangleShape: Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                moveTo(size.width / 2f, 0f)
                lineTo(0f, size.height)
                lineTo(size.width, size.height)
                close()
            }
        )
    }

}

data object StarShape: Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                val midX = size.width / 2f
                val midY = size.height / 2f
                val radiusOuter = minOf(size.width, size.height) / 2f
                val radiusInner = radiusOuter / 2.5f  // inner points

                val points = 5
                val angle = (2.0 * Math.PI / points).toFloat()
                moveTo(midX, midY - radiusOuter)

                for (i in 1 until points * 2) {
                    val r = if (i % 2 == 0) radiusOuter else radiusInner
                    val x = midX + (r * kotlin.math.sin(i * angle)).toFloat()
                    val y = midY - (r * kotlin.math.cos(i * angle)).toFloat()
                    lineTo(x, y)
                }
                close()
            }
        )
    }

}

@Preview(
    showBackground = true,
)
@Composable
private fun ShapeModifierDemoPreview() {
    ComposeHotelUITheme {
        ShapeModifierDemo()
    }
}