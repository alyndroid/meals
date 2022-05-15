package com.hamalawey.meals.di

import android.app.Application
import androidx.room.Room
import com.hamalawey.data.local.CategoriesDB
import com.hamalawey.data.local.CategoriesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(app: Application): CategoriesDB =
        Room.databaseBuilder(app, CategoriesDB::class.java, "categories_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMovieDao(categoriesDB: CategoriesDB): CategoriesDao = categoriesDB.categoriesDao()
}