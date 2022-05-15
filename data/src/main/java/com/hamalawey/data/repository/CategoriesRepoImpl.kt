package com.hamalawey.data.repository

import com.hamalawey.data.entities.CategoriesDataModel
import com.hamalawey.data.entities.CategoryDataModel
import com.hamalawey.data.local.CategoriesDao
import com.hamalawey.data.mappers.CategoriesMapper
import com.hamalawey.data.mappers.CategoryMapper
import com.hamalawey.data.remote.CategoriesApi
import com.hamalawey.domain.entities.Categories
import com.hamalawey.domain.entities.CategoryDomainModel
import com.hamalawey.domain.repository.CategoryRepo

class CategoriesRepoImpl(
    private val categoriesApi: CategoriesApi,
    private val categoriesDao: CategoriesDao
) : CategoryRepo {
    override fun getCategoriesFromDB(): Categories {
        return CategoriesMapper.mapToDomain(CategoriesDataModel(categoriesDao.getAllCategories()))
    }

    override fun setCategoriesToDB(categories: List<CategoryDomainModel>) {
        categoriesDao.addCategories(categories.map { CategoryMapper.mapToData(it) })
    }

    override suspend fun getCategoriesFromRemote(): Categories {
        return categoriesApi.getCategories()
    }
}