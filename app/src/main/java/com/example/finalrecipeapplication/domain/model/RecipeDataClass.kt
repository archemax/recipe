package com.example.finalrecipeapplication.domain.model

import com.example.finalrecipeapplication.data.dto.RecipeDto

data class RecipeDataClass(
    val id: Int,
    val sourceName: String,
    val image: String,
    val title: String,
    val preparationMinutes: Int,
)

fun RecipeDto.toRecipeDataClass(): RecipeDataClass {
    val firstRecipe = this.recipes.first()
    return RecipeDataClass(
        id = firstRecipe.id,
        image = firstRecipe.image,
        title = firstRecipe.title,
        preparationMinutes = firstRecipe.preparationMinutes,
        sourceName = firstRecipe.sourceName
    )
}