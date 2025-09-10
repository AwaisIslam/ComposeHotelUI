package com.ak.composehotelui.numberguess

sealed interface NumberGuessActions {
    data object OnGuessClick: NumberGuessActions
    data class OnNumberTextChange(val numberText: String): NumberGuessActions
    data object OnStartNewGameButton: NumberGuessActions
}