package com.example.finalrecipeapplication.presentation.screens.main_user_screen


import android.content.res.Configuration
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.finalrecipeapplication.R
import com.example.finalrecipeapplication.presentation.screens.recipe_list.RecipeListViewModel
import com.example.finalrecipeapplication.presentation.screens.recipe_list.components.RecipesListItem

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUserScreen(
    viewModel: RecipeListViewModel = hiltViewModel(),
    configuration: Configuration,
    toOneRecipeScreen: (String) -> Unit
) {
    val state = viewModel.state.value
    var finalText by remember { mutableStateOf("") }
    Log.d("AAASearchText", "$finalText")
    var active by remember { mutableStateOf(false) }
    var searchHistory by remember { mutableStateOf(listOf("")) }

//    fun filterRecipes(
//        recipes: List<RecipeDataClass>,
//        query: String
//    ): List<RecipeDataClass> {
//        return if (query.isBlank()) {
//            recipes // Return all recipes if the query is empty
//        } else {
//            recipes.filter { recipe ->
//                recipe.title!!.contains(query, ignoreCase = true)
//            }
//        }
//    }
//
//    var filteredRecipes by remember { mutableStateOf(state.recipes) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = {}) },
        bottomBar = { MyBottomNavigationBar() }
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {
            Text(
                modifier = Modifier.padding(),
                text = "what will you cook?",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.recipes) { recipe ->
                    RecipesListItem(
                        recipe = recipe,
                        onItemClick = {
                            toOneRecipeScreen(recipe.id.toString())
                            Log.d("AAAid", "${recipe.id}") //working logged
                        })
                }
            }
            MyBottomNavigationBar()
        }
    }

    SearchBar(
        query = finalText,
        onQueryChange = { finalText = it },
        onSearch = {
            //viewModel.getRecipesBySearch(finalText)
            active = false
            if (finalText.isNotEmpty()) {
                searchHistory = searchHistory + finalText
            }
        },
        active = active,
        onActiveChange = {
            active = it
        },
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
                    contentDescription = "close icon",
                    modifier = Modifier.clickable {
                        if (finalText.isNotEmpty()) {
                            finalText = ""
                        } else {
                            active = false
                        }
                    }, tint = LocalContentColor.current
                )
            }

        }
    ) {
        Text(
            modifier = Modifier
                .padding(all = 14.dp)
                .fillMaxWidth()
                .clickable {
                    searchHistory = emptyList()
                },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            text = "clear all history"
        )
        Divider()
        searchHistory.forEach { searchText ->
            if (searchText.isNotEmpty()) {
                Row(modifier = Modifier
                    .padding(all = 8.dp)
                    .clickable { finalText = searchText }
                ) {
                    Icon(imageVector = Icons.Default.History, contentDescription = null)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = searchText)
                }
            }
        }


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













