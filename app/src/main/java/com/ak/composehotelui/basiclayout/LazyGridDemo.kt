package com.ak.composehotelui.basiclayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun LazyGridDemo(modifier: Modifier = Modifier) {
    /*LazyVerticalGrid(
        columns = GridCells.Adaptive(50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(100){
            Box(modifier = modifier.height(100.dp)
                .background(Color(Random.nextInt())))
        }
    }*/
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(5),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(100){
            Box(modifier = modifier.height(
                height = Random.nextInt(
                    1..200
                ).dp
            )
                .clip(RoundedCornerShape(10.dp))
                .background(Color(Random.nextInt())))
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun LazyGridDemoPreview() {
    ComposeHotelUITheme {
        LazyGridDemo(Modifier)
    }
}