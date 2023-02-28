package com.example.featureapp.presentation.fragment.cash_book.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.featureapp.R
import com.example.featureapp.databinding.CategoryListItemBinding
import com.example.featureapp.presentation.fragment.cash_book.category.data.CategoryModel


class CategoryAdapter(private val onItemClicked: (item: CategoryModel) -> Unit) :
    ListAdapter<CategoryModel, CategoryAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(var view: CategoryListItemBinding) : RecyclerView.ViewHolder(view.root) {
        init {

            view.view.setOnClickListener { onItemClicked(getItem(adapterPosition)) }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.category_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.category = getItem(position)
        holder.view.categoryImg.setImageResource(getItem(position).image)
        holder.view.categoryImg.setBackgroundResource(getItem(position).color)

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CategoryModel>() {
            override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CategoryModel,
                newItem: CategoryModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}