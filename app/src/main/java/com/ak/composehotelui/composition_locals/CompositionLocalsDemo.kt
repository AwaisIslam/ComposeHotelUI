package com.ak.composehotelui.composition_locals

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme
import kotlinx.coroutines.launch

val LocalSnackbarState = staticCompositionLocalOf<SnackbarHostState> {
    error("Caution! Error")
}

@Composable
fun SnackbarProvider(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    content: @Composable (padding: PaddingValues) -> Unit
) {
    CompositionLocalProvider(
        LocalSnackbarState provides snackbarHostState
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}
@Composable
fun CompositionLocalsDemo(modifier: Modifier = Modifier) {
    SnackbarProvider {
        val snackbarState = LocalSnackbarState.current
        val scope = rememberCoroutineScope()

        Button(
            onClick = {
                scope.launch {
                    snackbarState.showSnackbar("Hello world!")
                }
            }
        ) {
            Text(
                text = "Click Me!"
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun CompositionLocalsDemoPrev() {
    ComposeHotelUITheme {
        CompositionLocalsDemo()
    }
}