package com.example.finalrecipeapplication.data.dto

data class RecipesDtoSearchResult(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)