package com.example.featureapp.presentation.fragment.cash_book.category.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featureapp.presentation.fragment.cash_book.category.data.CategoryModel
import com.example.featureapp.presentation.fragment.cash_book.category.data.categoryList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor() : ViewModel(){

    private val _categoryStateFlow = MutableStateFlow(emptyList<CategoryModel>())
    val categoryStateFlow =_categoryStateFlow.asStateFlow()


    init {
        getCategoryList()
    }

     private fun getCategoryList(){
        viewModelScope.launch {
            _categoryStateFlow.emit(categoryList)
        }
    }

}