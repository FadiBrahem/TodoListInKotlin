package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyApp() {
    var items by remember { mutableStateOf(listOf<String>()) }
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(items) { item ->
                Text(text = item, modifier = Modifier.padding(8.dp))
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.weight(1f),
                label = { Text("Enter item") }
            )
            Button(
                onClick = {
                    if (text.isNotEmpty()) {
                        items = items + text
                        text = ""
                    }
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Add")
            }
        }
    }
}
