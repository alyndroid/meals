package com.hamalawey.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryDataModel(
    @PrimaryKey(autoGenerate = true) val idCategory: Int,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)