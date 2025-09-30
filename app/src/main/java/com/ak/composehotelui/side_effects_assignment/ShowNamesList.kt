package com.ak.composehotelui.side_effects_assignment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun ShowNamesList(modifier: Modifier = Modifier) {
    val namesListViewModel = viewModel<NamesListViewModel>()
    val namesList by namesListViewModel.namesList.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = namesListViewModel.snackbarHostState
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .weight(1f),
                state = namesListViewModel.lazyList
            ) {
                items(namesList.size) { index ->
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = namesList[index].name
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ShowNamesListPreview() {
    ComposeHotelUITheme {
        ShowNamesList()
    }
}