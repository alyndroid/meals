package com.hamalawey.meals

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.hamalawey.meals.mvi.CategoriesIntent
import com.hamalawey.meals.mvi.CategoriesViewSates
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MealsViewModel by viewModels()
    lateinit var errorTv: TextView
    lateinit var loading: ProgressBar
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        errorTv = findViewById(R.id.error_tv)
        loading = findViewById(R.id.loading)
        recyclerView = findViewById(R.id.category_rv)
        render()
        lifecycleScope.launch {
            viewModel.intentsChannel.send(CategoriesIntent.LoadCategories)
        }

    }

    private fun render() {
        lifecycleScope.launch {
            viewModel.categories.collect {
                when (it) {
                    is CategoriesViewSates.Error -> {
                        errorTv.isVisible = true
                        loading.isVisible = false
                        recyclerView.isVisible = false
                    }
                    is CategoriesViewSates.Categories -> {
                        errorTv.isVisible = false
                        loading.isVisible = false
                        recyclerView.isVisible = true

                        val adapter = CategoryAdapter()
                        recyclerView.adapter = adapter
                        adapter.submitList(it.categories.categories)
                    }
                    is CategoriesViewSates.Loading -> {
                        errorTv.isVisible = false
                        loading.isVisible = true
                        recyclerView.isVisible = false
                    }
                }
            }
        }
    }
}