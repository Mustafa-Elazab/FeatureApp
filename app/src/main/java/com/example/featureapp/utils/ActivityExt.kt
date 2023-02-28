package com.example.featureapp.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.featureapp.MainActivity
import com.example.featureapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

fun Activity.makeStatusBarTransparent() {
    window.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        statusBarColor = Color.TRANSPARENT
    }
}


fun View.setMarginTop(marginTop: Int) {
    val menuLayoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
    menuLayoutParams.setMargins(0, marginTop, 0, 0)
    this.layoutParams = menuLayoutParams
}


fun Activity.hideSystemUI() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.setDecorFitsSystemWindows(false)
    } else {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}

fun MainActivity.showBottomNav(){
    val navigation = findViewById<BottomNavigationView>(R.id.bottom_nav)
    if(!navigation.isShown)
        navigation.show()
}

fun MainActivity.hideBottomNav(){
    val navigation = findViewById<BottomNavigationView>(R.id.bottom_nav)
    navigation.hide()
}