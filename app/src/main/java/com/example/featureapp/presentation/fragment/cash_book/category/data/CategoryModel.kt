package com.example.featureapp.presentation.fragment.cash_book.category.data

import android.os.Parcelable
import com.example.featureapp.R
import kotlinx.parcelize.Parcelize


@Parcelize
data class CategoryModel(
    var id: Int,
    var name: String,
    var color: Int,
    var image: Int
):Parcelable


var categoryList = listOf<CategoryModel>(
    CategoryModel(
        id = 1,
        name = "Food & Drinks",
        color = R.color.Red,
        image = R.drawable.food
    ),
    CategoryModel(
        id = 2,
        name = "Shopping",
        color = R.color.Blue,
        image = R.drawable.shopping
    ),
    CategoryModel(
        id = 3,
        name = "Housing",
        color = R.color.Green,
        image = R.drawable.home_analytics
    ),
    CategoryModel(
        id = 4,
        name = "Transportation",
        color = R.color.Red,
        image = R.drawable.train_car
    ),
    CategoryModel(
        id = 5,
        name = "Vehicle",
        color = R.color.Red,
        image = R.drawable.car
    ),
    CategoryModel(
        id = 6,
        name = "Life & Entertainment",
        color = R.color.Red,
        image = R.drawable.food
    ),
    CategoryModel(
        id = 7,
        name = "Communications & PC",
        color = R.color.Red,
        image = R.drawable.food
    ),
    CategoryModel(
        id = 8,
        name = "Financial expense",
        color = R.color.Red,
        image = R.drawable.food
    ),
    CategoryModel(
        id = 9,
        name = "Investments",
        color = R.color.Red,
        image = R.drawable.food
    ),
    CategoryModel(
        id = 10,
        name = "Income",
        color = R.color.Red,
        image = R.drawable.food
    ),
    CategoryModel(
        id = 11,
        name = "others",
        color = R.color.Red,
        image = R.drawable.food
    ),



)