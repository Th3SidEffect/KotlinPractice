package com.example.composepractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun ToDoList(modifier: Modifier) {

    var task by remember { mutableStateOf("") }
    var taskList by remember { mutableStateOf(mutableListOf<String>()) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = task,
                onValueChange = { item: String ->
                    task = item
                }
            )
            Button(
                {
                    if(task.isNotBlank()) {
                        taskList = (taskList + task) as MutableList<String>
                        task = ""
                    }
                }
            ) {
                Text(text = "Add")
            }
        }
        LazyColumn {
            items(taskList) { item ->
                Text(text = item)
            }
        }
    }
}