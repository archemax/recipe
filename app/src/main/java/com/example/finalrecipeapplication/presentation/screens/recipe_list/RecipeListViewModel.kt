package com.example.finalrecipeapplication.presentation.screens.recipe_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalrecipeapplication.common.Resource
import com.example.finalrecipeapplication.domain.use_case.get_recipes_list.GetRecipesUseCase
import com.example.finalrecipeapplication.presentation.screens.recipe_list.RecipeListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(RecipeListState())
    val state: State<RecipeListState> = _state // this is immutable state

    init {
        getRecipes()
    }

    //@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getRecipes() {
        getRecipesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RecipeListState(recipes = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = RecipeListState(
                        error = result.message ?: "Unexpected error"
                    )
                }

                is Resource.Loading -> {
                    _state.value = RecipeListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}