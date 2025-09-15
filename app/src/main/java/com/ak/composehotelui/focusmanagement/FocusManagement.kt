package com.ak.composehotelui.focusmanagement

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun FocusManagement(modifier: Modifier = Modifier) {

    val focusRequester = remember {  FocusRequester() }

    val focusManager = androidx.compose.ui.platform.LocalFocusManager.current
    Column(
        modifier = modifier.fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .focusRequester(focusRequester),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down)
                }
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .focusRequester(focusRequester),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down)
                }
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        val isFocused = remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(
                    width = 2.dp,
                    color = if (isFocused.value) Color.Green else Color.Red
                )
                .onFocusChanged{
                isFocused.value = it.isFocused
            }
                .focusable()
        )
        TextField(
            value = "",
            onValueChange = {},
        )
        Button(
            onClick ={
                focusRequester.requestFocus()
            }
        ) {
            Text(
                "Star Filling out form"
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun FocusManagementPreview() {
    ComposeHotelUITheme {
        FocusManagement()
    }
}