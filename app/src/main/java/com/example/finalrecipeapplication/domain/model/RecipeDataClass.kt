package com.example.finalrecipeapplication.domain.model

import com.example.finalrecipeapplication.data.dto.Recipe
import com.example.finalrecipeapplication.data.dto.RecipeDto

data class RecipeDataClass(
    val id: Int,
    val sourceName: String,
    val image: String?,
    val title: String,
    val preparationMinutes: Int,
    val instructions: String
)

fun Recipe.ToRecipeDataClass(): RecipeDataClass =
    RecipeDataClass(
        id = this.id,
        sourceName = this.sourceName,
        image = this.image ?:"",
        title = this.title,
        preparationMinutes = this.preparationMinutes,
        instructions = this.instructions
    )

fun RecipeDto.toListRecipeDataClass(): List<RecipeDataClass> =
    this.recipes.map { it.ToRecipeDataClass() }


