package com.example.finalrecipeapplication.domain.model

import com.example.finalrecipeapplication.data.dto.RecipeDetailsDto

data class RecipeDetailDataClass(
    val id: Int,
    val image: String,
    val instructions: String,
    val preparationMinutes: Int,
    val title: String,
)

fun RecipeDetailsDto.toRecipeDetailDataClass(): RecipeDetailDataClass {
    return RecipeDetailDataClass(
        id = id,
        image = image,
        instructions = instructions,
        preparationMinutes = preparationMinutes,
        title = title
    )
}


