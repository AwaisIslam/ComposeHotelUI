package com.ak.composehotelui.checkbox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ak.composehotelui.numberguess.NumberGuessActions
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
        modifier.fillMaxSize(),
    ) {
        LazyColumn(
            Modifier.weight(1f)
                .fillMaxWidth()
        ) {
            items(100) { i ->
                Card(
                    modifier = Modifier
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
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            Modifier.weight(1f)
                        ) {
                            Text(
                                text = "${state.title} $i",
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
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF53A954),
                                uncheckedColor = Color.Gray,
                                checkmarkColor = Color.White
                            )
                        )
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = null,
                                tint = Color(0xFF37852F)
                            )
                        }
                    }
                }
            }
        }
        Row(
            Modifier.fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                TextField(
                    value = "Item number",
                    onValueChange = {newText-> }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = "Item Description",
                    onValueChange = {newText-> }
                )
            }
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {}
            ) {
                Text(text = "Add Item")
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
