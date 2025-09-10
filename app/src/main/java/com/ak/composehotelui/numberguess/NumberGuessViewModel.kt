package com.ak.composehotelui.numberguess

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NumberGuessViewModel : ViewModel() {

    private var number = Random.nextInt(1,100)
    private var attempts = 0

    private val _state = MutableStateFlow(NumberGuessStates())
    val state = _state.asStateFlow()

    fun onAction(action: NumberGuessActions) {
        when (action) {
            NumberGuessActions.OnGuessClick -> {
                val guess = state.value.numberText.toIntOrNull()
                if (guess != null){
                    attempts++
                }

                _state.update { it.copy(
                    guessText = when{
                        guess == null -> "Please enter a number"
                        number > guess -> "Nope, my number is larger"
                        number < guess -> "Nope, my number is smaller"
                        else -> "Hurray! You did it in $attempts attempts."
                    },
                    isGuessCorrect = guess == number,
                    numberText = ""
                ) }
            }

            is NumberGuessActions.OnNumberTextChange -> {
                _state.update {
                    it.copy(
                        numberText = action.numberText
                    )
                }
            }

            NumberGuessActions.OnStartNewGameButton -> {
                attempts = 0
                number = Random.nextInt(1,100)
                _state.update { it.copy(
                    numberText = "",
                    guessText = null,
                    isGuessCorrect = false
                ) }
            }
        }
    }
}