package com.hamalawey.data.remote

import com.hamalawey.domain.entities.Categories
import com.hamalawey.domain.entities.CategoryDomainModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface CategoriesApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getCategories(): Categories
}