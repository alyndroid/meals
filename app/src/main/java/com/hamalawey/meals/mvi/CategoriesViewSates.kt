package com.hamalawey.meals.mvi

import com.hamalawey.data.entities.CategoriesDataModel
import com.hamalawey.domain.entities.Categories

sealed class CategoriesViewSates{
    object Loading: CategoriesViewSates()
    object Error: CategoriesViewSates()
    data class Categories(val categories: com.hamalawey.domain.entities.Categories):CategoriesViewSates()
}
