package com.ak.composehotelui.numberguess

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme


@Composable
fun NumberGuessScreenRoot(modifier: Modifier = Modifier) {
    val viewModel = viewModel<NumberGuessViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    NumberGuessScreen(modifier, onAction = viewModel::onAction, state)
}
@Composable
fun NumberGuessScreen(
    modifier: Modifier = Modifier,
    onAction: (NumberGuessActions) -> Unit,
    state: NumberGuessStates
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.numberText,
            onValueChange = {newText->
                onAction(NumberGuessActions.OnNumberTextChange(newText))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = {
                onAction(NumberGuessActions.OnGuessClick)
            }
        ) {
            Text(text = "Guess Number")
        }
        if (state.guessText != null){
            Text(text = state.guessText)
        }
        if (state.isGuessCorrect){
            Button(
                onClick = {
                    onAction(NumberGuessActions.OnStartNewGameButton)
                }
            ) {
                Text(text = "Start new game")
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun NumberGuessScreenPreview() {
    ComposeHotelUITheme {
        NumberGuessScreen(state = NumberGuessStates(), onAction = {})
    }
}