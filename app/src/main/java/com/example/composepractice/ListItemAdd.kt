package com.example.composepractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewList(modifier: Modifier) {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(mutableListOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = name,
                onValueChange = { text: String ->
                    name = text
                },
                modifier = Modifier.weight(1f)
            )
            Button(
                {
                    if (name.isNotBlank()) {
                        names = (names + name) as MutableList<String>
                        name = ""
                    }
                }
            ) {
                Text(text = "Add")
            }
        }
        LazyColumn {
            items(names) { name ->
                Text(text = name)
            }
        }
    }
}