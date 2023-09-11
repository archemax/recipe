package com.example.finalrecipeapplication.presentation.screens.main_user_screen


import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.finalrecipeapplication.R
import com.example.finalrecipeapplication.presentation.screens.recipe_list.RecipeListViewModel
import com.example.finalrecipeapplication.presentation.screens.recipe_list.components.RecipesListItem

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUserScreen(
    navController: NavController,
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp),

        topBar = { TopAppBar(title = {}) },

        bottomBar = { MyBottomNavigationBar() }

    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            Text(
                modifier = Modifier.padding(it),
                text = "what will you cook?",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)

            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.recipes) { recipe ->
                    RecipesListItem(
                        recipe = recipe,
                        onItemClick = {

                    })
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

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

@Composable
fun MyBottomNavigationBar() {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_soup_kitchen_24),
                    contentDescription = null
                )
            },
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

@Composable
fun MyCard(item: Int) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Position")
        Text(text = "$item")
    }
}


@Preview(showSystemUi = true)
@Composable
fun MainUserScreenPreview() {
    //MainUserScreen(navController = NavController(context = Context))
}








