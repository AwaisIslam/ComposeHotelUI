package com.ak.composehotelui.checkbox

sealed interface TodoActions

data class OnTextStrikeThrough(val index: Int, val isChecked: Boolean) : TodoActions
data class OnAddTitle(val title: String) : TodoActions
data class OnAddDescription(val description: String) : TodoActions
data object OnAddItem : TodoActions
data class OnDeleteItem(val index: Int) : TodoActions