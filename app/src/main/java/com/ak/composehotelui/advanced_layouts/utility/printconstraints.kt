package com.ak.composehotelui.advanced_layouts.utility

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.printConstraints(tag: String): Modifier{
    return layout { measurable, constraints->
        println("$tag width: ${constraints.maxWidth} height: ${constraints.maxHeight}")
        val placeable = measurable.measure(constraints)
        layout(placeable.width, placeable.height){
            placeable.placeRelative(0,0)
        }
    }
}