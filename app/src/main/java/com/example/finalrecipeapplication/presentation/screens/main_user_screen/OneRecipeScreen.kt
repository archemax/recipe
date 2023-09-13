package com.example.finalrecipeapplication.presentation.screens.main_user_screen

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.finalrecipeapplication.presentation.screens.recipe_list.components.RecipeDetailViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun OneRecipeScreen(
    recipeDetailViewModel: RecipeDetailViewModel = hiltViewModel(),
    navController: NavController
    //recipeId: String
) {
    val oneRecipeState = recipeDetailViewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize()
    ) {//commom column before bottom bar
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
        ) { // column for padding
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {// arrow
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { navController.popBackStack()},
                        modifier = Modifier
                            .size(48.dp)
                            .clip(MaterialTheme.shapes.small)
                    ) { //arrow back
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "${oneRecipeState.recipes?.title}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

                Column(modifier = Modifier.fillMaxSize()) {
                    Row() {
                        AsyncImage(
                            model = oneRecipeState.recipes?.image,
                            contentDescription = "recipe Image",
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(text = "${oneRecipeState.recipes?.instructions}")
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))

            }
        }
        MyBottomNavigationBar()
    }
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Preview(showSystemUi = true)
@Composable
fun RecipeCardPreview() {
    //OneRecipeScreen()
}


