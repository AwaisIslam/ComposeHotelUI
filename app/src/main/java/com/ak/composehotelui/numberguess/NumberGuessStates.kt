package com.ak.composehotelui.numberguess

data class NumberGuessStates(
    val numberText: String = "",
    val guessText: String? = "",
    val isGuessCorrect: Boolean = false
)