package com.example.featureapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.featureapp.R


@BindingAdapter("loadImage")
fun ImageView.loadImage(imageUrl: String?) {
    imageUrl?.let {
        Glide.with(context)
            .load(it)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.home_analytics)
            .into(this)
    }
}