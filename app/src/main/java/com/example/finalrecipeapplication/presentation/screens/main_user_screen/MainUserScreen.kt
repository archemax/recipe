package com.example.finalrecipeapplication.presentation.screens.main_user_screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.finalrecipeapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUserScreen() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),

        topBar = {
            TopAppBar(
                title = {},

            )
        },

        bottomBar = {
            NavigationBar(modifier = Modifier.fillMaxWidth()) {
                NavigationBarItem(
                    selected = true,
                    icon = { Icon(Icons.Outlined.Build, contentDescription = null) },
                    onClick = {},
                    label = { Text(text = "Recipes") }
                )

                NavigationBarItem(
                    selected = true,
                    icon = {
                        Icon(
                            Icons.Outlined.Favorite,
                            contentDescription = null
                        )
                    },
                    onClick = {},
                    label = { Text(text = "Favourite") }
                )

                NavigationBarItem(
                    selected = true,
                    icon = { Icon(Icons.Outlined.Person, contentDescription = null) },
                    onClick = {},
                    label = { Text(text = "Profile") }
                )
            }
        }


    ) {
        Column() {
            Text(
                modifier = Modifier.padding(it),
                text = "what will you cook?"
            )
            val list = listOf<Int>(1,2,3,4,5,6)
            LazyColumn(){
                items(list.size){item-> 
                    Text(text = "$item")
                }
            }

        }
       

        SearchBar(
            query = text,
            onQueryChange = { text = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text(text = "Search") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_filter_alt_24),
                    contentDescription = "",
                    Modifier
                        .clickable { }
                        .padding(end = 8.dp, start = 8.dp),

                )
            },
            trailingIcon = {
                if (active) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier.clickable { text = "" },
                        tint = LocalContentColor.current
                    )
                }

            }
        ) {}
    }
}














