package com.example.finalrecipeapplication.presentation.screens.main_user_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserFilterScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(48.dp)
                        .clip(MaterialTheme.shapes.small)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                OutlinedButton(
                    onClick = { /*TODO: Clear All*/ },
                    modifier = Modifier

                        .clip(MaterialTheme.shapes.small)
                ) {
                    Text("Clear All")
                }
            }



            FilterRow("Meal type")
            FilterRow("Allergies")
            FilterRow("Diet")

        }
        MyBottomNavigationBar()


    }
}


@Composable
fun FilterRow(name: String) {
    Text(name)
    Row() {
        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {}
        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {}
        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {}
    }
}


@Preview(showSystemUi = true)
@Composable
fun UserFilterScreenPreview() {
    UserFilterScreen()
}