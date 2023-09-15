package com.example.finalrecipeapplication.domain.model

import com.example.finalrecipeapplication.data.dto.Recipe
import com.example.finalrecipeapplication.data.dto.RecipeDto
import com.example.finalrecipeapplication.data.dto.RecipesDtoSearchResult
import com.example.finalrecipeapplication.data.dto.Result

data class RecipeDataClass(
    val id: Int,
    val sourceName: String,
    val image: String,
    val title: String,
    val preparationMinutes: Int,
    val instructions: String,
    val imageType: String
)

fun Recipe.toRecipeDataClass(): RecipeDataClass =
    RecipeDataClass(
        id = this.id,
        sourceName = this.sourceName,
        image = this.image,
        title = this.title,
        preparationMinutes = this.preparationMinutes,
        instructions = this.instructions,
        // added
        imageType = ""
    )

fun RecipeDto.toListRecipeDataClass(): List<RecipeDataClass> {
    return this.recipes.map { it.toRecipeDataClass() }
}


// new mapping for search result

fun Result.toRecipeDataClass(): RecipeDataClass {
    return RecipeDataClass(
        id = this.id,
        image = this.image,
        imageType = this.imageType,
        title = this.title,
        sourceName = "",
        preparationMinutes = 0,
        instructions = ""
    )
}

fun RecipesDtoSearchResult.toListRecipeDataClass(): List<RecipeDataClass> {
    return this.results.map {
        it.toRecipeDataClass()
    }
}