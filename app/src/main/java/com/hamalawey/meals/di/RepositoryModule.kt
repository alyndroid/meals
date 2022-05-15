package com.hamalawey.meals.di

import com.hamalawey.data.local.CategoriesDao
import com.hamalawey.data.remote.CategoriesApi
import com.hamalawey.data.repository.CategoriesRepoImpl
import com.hamalawey.domain.repository.CategoryRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMoviesRepository(
        categoriesApi: CategoriesApi,
        categoriesDao: CategoriesDao
    ): CategoryRepo =
        CategoriesRepoImpl(categoriesApi, categoriesDao)
}