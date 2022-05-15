package com.hamalawey.domain.usecase

import com.hamalawey.domain.repository.CategoryRepo

class GetCategoriesFromDB(private val categoryRepo: CategoryRepo){
    operator fun invoke() = categoryRepo.getCategoriesFromDB()
}