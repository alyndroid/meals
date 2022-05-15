package com.hamalawey.meals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hamalawey.meals.R
import com.hamalawey.domain.entities.CategoryDomainModel
import kotlinx.android.synthetic.main.category_item.view.*


class CategoryAdapter() :
    ListAdapter<CategoryDomainModel, CategoryAdapter.ViewHolder>(
        CategoryDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.category_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            category: CategoryDomainModel
        ) {
            itemView.category_name_tv.text = category.strCategory
            itemView.category_des_tv.text = category.strCategoryDescription
            Glide.with(itemView.context).load(category.strCategoryThumb).into(itemView.category_iv)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryDomainModel>() {
        override fun areItemsTheSame(
            oldItem: CategoryDomainModel,
            newItem: CategoryDomainModel
        ): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(
            oldItem: CategoryDomainModel,
            newItem: CategoryDomainModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}