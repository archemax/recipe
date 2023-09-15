package com.example.finalrecipeapplication.presentation.screens.recipe_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.finalrecipeapplication.domain.model.RecipeDataClass

@Composable
fun RecipesListItem(
    recipe: RecipeDataClass,
    onItemClick: (RecipeDataClass) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(recipe) }
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    )
    {
        //val testImage: Painter = painterResource(id = R.drawable.outline_soup_kitchen_24)
        Row(
            modifier = Modifier.padding(0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = recipe.image,
                modifier = Modifier.size(120.dp),
                contentDescription = "image of recipe",
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = recipe.title.toString(),
                modifier = Modifier.padding(4.dp).weight(1f),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
//horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "${recipe.preparationMinutes}", fontSize = 16.sp)
            Text(text = recipe.instructions.toString(), maxLines = 2)

        }
    }
}

