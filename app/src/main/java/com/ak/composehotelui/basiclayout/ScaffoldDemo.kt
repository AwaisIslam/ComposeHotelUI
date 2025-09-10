package com.ak.composehotelui.basiclayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDemo(modifier: Modifier = Modifier) {
    val state = remember {
        SnackbarHostState()
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "heading"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    state.showSnackbar(
                        "I am Floating Action Button"
                    )
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        },
        snackbarHost = {
            SnackbarHost(
                hostState = state
            )
        },
        bottomBar = {
            BottomAppBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    },
                    label =  {
                        Text(
                            text = "Favourites"
                        )
                    }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    label =  {
                        Text(
                            text = "Search"
                        )
                    }
                )
            }
        }
    ) {
        paddingValues ->
        Box(modifier = Modifier.fillMaxSize()
            .padding(paddingValues)
            .background(Color.LightGray)){
            Text(
                text = "Hello World!"
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun LazyGridDemoPreview() {
    ComposeHotelUITheme {
        ScaffoldDemo(Modifier)
    }
}