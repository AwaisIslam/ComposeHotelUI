package com.ak.composehotelui.side_effects_assignment

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class Names(
    val name: String = ""
)

class NamesListViewModel : ViewModel() {
    private var _namesList = MutableStateFlow(listOf(Names()))
    val namesList = _namesList.asStateFlow()

    val snackbarHostState = SnackbarHostState()
    val lazyList = LazyListState()

    init {
        _namesList.update {
            it.toMutableList().apply {
                add(Names("John"))
                add(Names("Jane"))
                add(Names("Jill"))
                add(Names("Joe"))
                add(Names("Jake"))
                add(Names("Jenna"))
                add(Names("Jacqueline"))
                add(Names("Jacquelyn"))
                add(Names("Jacquelyne"))
                add(Names("Jacque"))
                add(Names("Jacquline"))
                add(Names("Jacqulyn"))
                add(Names("Jacqalyne"))
                add(Names("Josh"))
                add(Names("Joshua"))
                add(Names("Jake"))
                add(Names("John"))
                add(Names("Jane"))
                add(Names("Jill"))
                add(Names("Joe"))
                add(Names("Jake"))
                add(Names("Jenna"))
                add(Names("Jacqueline"))
                add(Names("Jacquelyn"))
                add(Names("Jacquelyne"))
                add(Names("Jacque"))
                add(Names("Jacquline"))
                add(Names("Jacqulyn"))
                add(Names("Jacqalyne"))
                add(Names("Josh"))
                add(Names("Joshua"))
                add(Names("Jake"))
            }
        }

        viewModelScope.launch {
            snapshotFlow {
                val lastVisible = lazyList.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                lastVisible == _namesList.value.lastIndex
            }.distinctUntilChanged().collect { atBottom ->
                if (atBottom) {
                    snackbarHostState.showSnackbar("Scrolled to the bottom!")
                }
            }
        }
    }
}