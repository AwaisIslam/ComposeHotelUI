package com.ak.composehotelui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ak.composehotelui.checkbox.TodoScreenRoot
import com.ak.composehotelui.dragable.DraggableModifiers
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeHotelUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*HotelBookingScreen(
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    //NumberGuessScreenRoot(modifier = Modifier.padding(innerPadding))
                    //TodoScreenRoot(modifier = Modifier.padding(innerPadding))
                    //FocusManagement(modifier = Modifier.padding(innerPadding))
                    DraggableModifiers(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeHotelUITheme {
        //HotelBookingScreen()
        //NumberGuessScreenRoot()
        TodoScreenRoot()
    }
}