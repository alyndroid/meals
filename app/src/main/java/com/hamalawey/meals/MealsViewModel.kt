package com.hamalawey.meals

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamalawey.domain.entities.Categories
import com.hamalawey.domain.entities.CategoryDomainModel
import com.hamalawey.domain.usecase.GetCategoriesFromDB
import com.hamalawey.domain.usecase.GetCategoriesFromRemote
import com.hamalawey.domain.usecase.SetCategoriesToDB
import com.hamalawey.meals.mvi.CategoriesIntent
import com.hamalawey.meals.mvi.CategoriesViewSates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MealsViewModel@Inject constructor(
    private val getCategoriesFromDB: GetCategoriesFromDB,
    private val setCategoriesToDB: SetCategoriesToDB,
    private val getCategoriesFromRemote: GetCategoriesFromRemote
) : ViewModel() {
    val intentsChannel = Channel<CategoriesIntent>(Channel.UNLIMITED)

    private val _categories: MutableStateFlow<CategoriesViewSates> = MutableStateFlow(CategoriesViewSates.Loading)
    val categories: StateFlow<CategoriesViewSates> = _categories

    init {
        processIntents()
    }

    private fun processIntents(){
        viewModelScope.launch {
            intentsChannel.consumeAsFlow().collect(){
                when (it){
                    is CategoriesIntent.LoadCategories -> getCategories()
                }
            }
        }
    }

    private fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            _categories.value = try {
                val categories = getCategoriesFromDB.invoke()
                
                if (categories.categories.isEmpty()){
                   setCategoriesToDB(getCategoriesFromRemote.invoke().categories)
                }
                CategoriesViewSates.Categories(getCategoriesFromDB.invoke())
            } catch (e: Exception){
                Log.d("here",e.message.toString())
                CategoriesViewSates.Error
            }
        }
    }

}