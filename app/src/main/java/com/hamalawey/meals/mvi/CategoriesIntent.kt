package com.hamalawey.meals.mvi

sealed class CategoriesIntent{
    object LoadCategories: CategoriesIntent()
}
