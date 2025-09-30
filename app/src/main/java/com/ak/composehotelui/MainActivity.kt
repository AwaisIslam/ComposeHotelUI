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
import com.ak.composehotelui.side_effects_assignment.ShowNamesList
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
                    //DraggableModifiers(modifier = Modifier.padding(innerPadding))
                    /*Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        var page by remember {
                            mutableIntStateOf(0)
                        }
                        SubComposePagedRow(
                            page
                        ) {
                            (1..1000).forEach { _ ->
                                Box(
                                    Modifier
                                        .width(Random.nextInt(300).dp)
                                        .height(100.dp)
                                        .background(Color(Random.nextInt()))
                                )
                            }
                        }
                        Button(
                            onClick = {page++}
                        ) {
                            Text(
                                text = "Go to next page"
                            )
                        }
                    }*/
                    /*val mindMapItems = remember {
                        listOf(
                            MindMapItem(
                                title = "hello World1",
                                percentOffset = Offset(
                                    0f,0f
                                )
                            ),
                            MindMapItem(
                                title = "hello World2",
                                percentOffset = Offset(
                                    1f,0f
                                )
                            ),
                            MindMapItem(
                                title = "hello World3",
                                percentOffset = Offset(
                                    0.3f,-0.5f
                                )
                            ),
                            MindMapItem(
                                title = "hello World4",
                                percentOffset = Offset(
                                    -0.2f,1.5f
                                )
                            )
                        )
                    }
                    var mindMapOffset by remember {
                        mutableStateOf(IntOffset.Zero)
                    }
                    LazyMindMapLayout(
                        items = mindMapItems,
                        mindMapOffset = mindMapOffset,
                        onDrag = {
                            mindMapOffset += it
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }*/
                    ShowNamesList(
                        modifier = Modifier.padding(innerPadding)
                    )
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
            //TodoScreenRoot()
            ShowNamesList()
        }
    }
}