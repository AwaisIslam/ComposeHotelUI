package com.ak.composehotelui.checkbox

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel: ViewModel() {

    private val _todoState = MutableStateFlow(TodoStates())
    val todoState = _todoState.asStateFlow()

    fun onAction(action: TodoActions){
        when(action) {
            is TodoActions.OnTextStrikeThrough -> {
                _todoState.update { it.copy(isChecked = action.isChecked) }
            }
        }
    }
}