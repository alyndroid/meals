package com.hamalawey.meals.di

import com.hamalawey.domain.repository.CategoryRepo
import com.hamalawey.domain.usecase.GetCategoriesFromDB
import com.hamalawey.domain.usecase.GetCategoriesFromRemote
import com.hamalawey.domain.usecase.SetCategoriesToDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetCategoriesFromDBUseCase(categoryRepo: CategoryRepo) =
        GetCategoriesFromDB(categoryRepo)

    @Provides
    fun provideGetCategoriesFromRemoteUseCase(categoryRepo: CategoryRepo) =
        GetCategoriesFromRemote(categoryRepo)

    @Provides
    fun provideSetCategoriesToRemoteUseCase(categoryRepo: CategoryRepo) =
        SetCategoriesToDB(categoryRepo)
}