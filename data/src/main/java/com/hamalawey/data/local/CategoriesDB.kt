package com.hamalawey.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hamalawey.data.entities.CategoryDataModel
import com.hamalawey.domain.entities.CategoryDomainModel

@Database(
    entities = [CategoryDataModel::class],
    version = 1,
    exportSchema = false
)
abstract class CategoriesDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao
}