package com.hamalawey.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hamalawey.data.entities.CategoryDataModel

@Dao
interface CategoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCategories(categories: List<CategoryDataModel>)

    @Query("SELECT * FROM categories")
    fun getAllCategories(): List<CategoryDataModel>
}