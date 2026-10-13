package com.example.composepractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun NameGreeting(modifier: Modifier) {

    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        TextField(
            value = name,
            onValueChange = {text: String ->
                name = text
            }
        )

        Text(text = "Hello $name")
    }
}