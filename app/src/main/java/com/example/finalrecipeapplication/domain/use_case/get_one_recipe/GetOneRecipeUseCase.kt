package com.example.finalrecipeapplication.domain.use_case.get_recipes_list

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.finalrecipeapplication.common.Resource
import com.example.finalrecipeapplication.domain.model.RecipeDetailDataClass
import com.example.finalrecipeapplication.domain.model.toRecipeDetailDataClass
import com.example.finalrecipeapplication.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetOneRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(recipeId: String): Flow<Resource<RecipeDetailDataClass>> =
        flow {
            try {
                emit(Resource.Loading())
                val oneRecipe = repository.getRecipeById(recipeId).toRecipeDetailDataClass()
                emit(Resource.Success(oneRecipe))

            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
            } catch (e: IOException) {
                emit(Resource.Error("No connection to server... check your internet connection"))
            }
        }
}