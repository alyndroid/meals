package com.hamalawey.domain.usecase

import com.hamalawey.domain.repository.CategoryRepo

class GetCategoriesFromRemote(private val categoryRepo: CategoryRepo) {
    suspend fun invoke() = categoryRepo.getCategoriesFromRemote()
}