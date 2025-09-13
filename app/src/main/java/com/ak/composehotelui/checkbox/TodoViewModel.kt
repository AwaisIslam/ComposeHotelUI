package com.ak.composehotelui.checkbox

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel : ViewModel() {

    private val _todoState = MutableStateFlow(TodoStates())
    val todoState = _todoState.asStateFlow()

    private val _todoList = MutableStateFlow(listOf<TodoStates>())
    val todoList = _todoList.asStateFlow()

    init {
        _todoList.update {
            it.toMutableList().apply {
                add(TodoStates(
                    title = "Title 1",
                    description = "Description 1"
                ))
                add(TodoStates(
                    title = "Title 2",
                    description = "Description 2"
                ))
                add(TodoStates(
                    title = "Title 3",
                    description = "Description 3"
                ))
                add(TodoStates(
                    title = "Title 4",
                    description = "Description 4"
                ))
                add(TodoStates(
                    title = "Title 5",
                    description = "Description 5"
                ))
            }
        }
    }

    fun onAction(action: TodoActions) {
        when (action) {
            is OnTextStrikeThrough -> {
                _todoList.update { list ->
                    list.toMutableList().apply {
                        this[action.index] = this[action.index].copy(isChecked = action.isChecked)
                    }
                }
            }
            is OnAddTitle -> {
                _todoState.update { it.copy(title = action.title) }
            }
            is OnAddDescription -> {
                _todoState.update { it.copy(description = action.description) }
            }

            OnAddItem -> {
                _todoList.update {
                    it.toMutableList().apply {
                        add(todoState.value)
                    }
                }
                _todoState.update { TodoStates() }
            }

            is OnDeleteItem -> {
                _todoList.update { list ->
                    list.toMutableList().apply {
                        removeAt(action.index)
                    }
                }
            }
        }
    }
}