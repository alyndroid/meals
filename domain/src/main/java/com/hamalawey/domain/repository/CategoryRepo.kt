package com.hamalawey.domain.repository

import com.hamalawey.domain.entities.Categories
import com.hamalawey.domain.entities.CategoryDomainModel

interface CategoryRepo {
    fun getCategoriesFromDB(): Categories
    fun setCategoriesToDB(categories: List<CategoryDomainModel>)
    suspend fun getCategoriesFromRemote(): Categories
}