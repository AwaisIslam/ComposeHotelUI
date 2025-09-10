package com.ak.composehotelui.checkbox

sealed interface TodoActions {
    data class OnTextStrikeThrough(val isChecked: Boolean) : TodoActions
}