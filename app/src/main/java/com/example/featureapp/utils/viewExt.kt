package com.example.featureapp.utils

import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}
