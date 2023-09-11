package com.example.finalrecipeapplication.presentation.screens.recipe_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalrecipeapplication.R
import com.example.finalrecipeapplication.domain.model.RecipeDataClass

@Composable
fun RecipesListItem(
    recipe: RecipeDataClass,
    onItemClick: (RecipeDataClass) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(recipe) }
            .padding(8.dp),

        )
    {
        val testImage: Painter = painterResource(id = R.drawable.outline_soup_kitchen_24)
        Image(
            painter = testImage,
            contentDescription = null,
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Name of the recipe", fontSize = 24.sp)
            Text(text = "minutes", fontSize = 16.sp)

        }
    }
}

@Preview(showSystemUi = true)
@Composable()
fun RecipesListItemPreview() {
    RecipesListItem(
        recipe = RecipeDataClass(
            1,
            "name", "Image", "title", 33
        ),

        onItemClick = {}
    )
}