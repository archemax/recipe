package com.example.finalrecipeapplication.presentation.screens.recipe_list.components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalrecipeapplication.common.Constants
import com.example.finalrecipeapplication.common.Resource
import com.example.finalrecipeapplication.domain.use_case.get_recipes_list.GetOneRecipeUseCase
import com.example.finalrecipeapplication.domain.use_case.get_recipes_list.GetRecipesUseCase
import com.example.finalrecipeapplication.presentation.screens.recipe_detail.components.RecipeDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val getOneRecipeUseCase: GetOneRecipeUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(RecipeDetailState())
    val state: State<RecipeDetailState> = _state // this is immutable state

    init {
        savedStateHandle.get<String>(Constants.PARAM_RECIPE_ID)?.let {recipeId->
            getOneRecipeDetails(recipeId)
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getOneRecipeDetails(recipeId: String) {
        getOneRecipeUseCase(recipeId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RecipeDetailState(recipes = result.data)
                }

                is Resource.Error -> {
                    _state.value = RecipeDetailState(
                        error = result.message ?: "Unexpected error"
                    )
                }

                is Resource.Loading -> {
                    _state.value = RecipeDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}