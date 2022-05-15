package com.hamalawey.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CategoryDomainModel(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)