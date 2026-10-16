package com.example.whatsappclone.chatsList

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

@Composable
fun ChatsListScreen(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf("") }

    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            Row(
                Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .background(Color.Transparent)
                    .border(
                        width = 2.dp, color = Color(0xFF176B36), shape = CircleShape
                    )
            ) {

                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text("Search")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar"
                        )
                    },
                    shape = CircleShape,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color(0xFF176B36)
                    ),
                    singleLine = true
                )
            }
            Row() {
                val filters = remember {
                    mutableStateListOf("All", "Unread", "Groups")
                }

                var selectedFilter by remember {
                    mutableStateOf("All")
                }

                Row {
                    filters.forEach { filter ->
                        val isSelected = selectedFilter == filter

                        Button(
                            onClick = {
                                selectedFilter = filter
                            }, modifier = Modifier.padding(
                                end = 8.dp, top = 16.dp, bottom = 16.dp
                            ), colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSelected) {
                                    Color(0xFFD9FDD3)
                                } else {
                                    Color.Transparent
                                }, contentColor = if (isSelected) {
                                    Color(0xFF176B36)
                                } else {
                                    Color.Black
                                }
                            ), elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 0.dp
                            )
                        ) {
                            Text(filter)
                        }
                    }
                }
            }
        }
    }
    // search text field
    // chats filter
    // chats list
}

@Preview
@Composable
private fun ChatsListScreenPreview() {
    WhatsAppCloneTheme {
        Surface {
            ChatsListScreen()
        }
    }
}