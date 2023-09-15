package com.example.finalrecipeapplication.domain.use_case.get_recipe_by_search

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.finalrecipeapplication.common.Resource
import com.example.finalrecipeapplication.domain.model.RecipeDataClass
import com.example.finalrecipeapplication.domain.model.toListRecipeDataClass
import com.example.finalrecipeapplication.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import java.io.IOException

import javax.inject.Inject

class GetRecipeBySearchUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(query: String): Flow<Resource<List<RecipeDataClass>>> =
        flow<Resource<List<RecipeDataClass>>> {
            try {
                emit(Resource.Loading())
                val recipesDtoSearchResult = repository.getRecipesBySearch(query)
                val recipesSearchedList = recipesDtoSearchResult.toListRecipeDataClass()

                emit(Resource.Success(recipesSearchedList))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "Unknown search error"))
            } catch (e: IOException) {
                emit(Resource.Error("No connection to the server"))
            }

        }
}