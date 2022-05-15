package com.hamalawey.domain.usecase

import com.hamalawey.domain.entities.CategoryDomainModel
import com.hamalawey.domain.repository.CategoryRepo

class SetCategoriesToDB(private val categoryRepo: CategoryRepo){
    operator fun invoke(categories: List<CategoryDomainModel>) = categoryRepo.setCategoriesToDB(categories)
}