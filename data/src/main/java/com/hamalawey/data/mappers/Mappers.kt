package com.hamalawey.data.mappers

import com.hamalawey.data.entities.CategoriesDataModel
import com.hamalawey.data.entities.CategoryDataModel
import com.hamalawey.domain.entities.Categories
import com.hamalawey.domain.entities.CategoryDomainModel

object CategoryMapper {
    fun mapToData(model: CategoryDomainModel): CategoryDataModel {
        with(model) {
            return CategoryDataModel(
                idCategory = idCategory.toInt(),
                strCategory = strCategory,
                strCategoryDescription = strCategoryDescription,
                strCategoryThumb = strCategoryThumb
            )
        }
    }

    fun mapToDomain(model: CategoryDataModel): CategoryDomainModel{
        with(model){
            return CategoryDomainModel(
                idCategory = idCategory.toString(),
                strCategory = strCategory,
                strCategoryDescription = strCategoryDescription,
                strCategoryThumb = strCategoryThumb
            )}
    }
}
object CategoriesMapper {
    fun mapToData(model :Categories): CategoriesDataModel {
        return CategoriesDataModel(
            categories = model.categories.map {CategoryMapper.mapToData(it)}
        )
    }

    fun mapToDomain(model: CategoriesDataModel): Categories{
        return Categories(
            categories = model.categories.map { CategoryMapper.mapToDomain(it) }
        )
    }
}



