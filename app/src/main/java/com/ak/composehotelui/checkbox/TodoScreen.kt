package com.ak.composehotelui.checkbox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ak.composehotelui.ui.theme.ComposeHotelUITheme

@Composable
fun TodoScreenRoot(modifier: Modifier = Modifier) {
    val todoViewModel = viewModel<TodoViewModel>()
    val state by todoViewModel.todoState.collectAsStateWithLifecycle()
    TodoScreen(modifier, state, onAction = todoViewModel::onAction)
}

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier,
    state: TodoStates,
    onAction: (TodoActions) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC2D7BC)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            border = BorderStroke(2.dp, Color(0xFF53A954))
        ) {
            Row(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    Modifier.weight(1f)
                ) {
                    Text(
                        text = state.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.LineThrough.takeIf { state.isChecked }
                            ?: TextDecoration.None
                    )
                    Text(
                        text = state.description,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.LineThrough.takeIf { state.isChecked }
                            ?: TextDecoration.None
                    )
                }
                Checkbox(
                    checked = state.isChecked,
                    onCheckedChange = {
                        onAction(TodoActions.OnTextStrikeThrough(isChecked = it))
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoScreenPreview() {
    ComposeHotelUITheme {
        TodoScreen(
            state = TodoStates(),
            onAction = {}
        )
    }
}

/*
Card(
modifier = modifier.padding(16.dp)
.fillMaxWidth(),
shape = RoundedCornerShape(16.dp),
colors = CardDefaults.cardColors(
containerColor = Color(0xFFC2D7BC)
),
elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
border = BorderStroke(2.dp, Color(0xFF8369AD))
) {*/
