package com.example.featureapp.utils

import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import androidx.fragment.app.Fragment

fun Fragment.changeStatusBarColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        activity?.window?.statusBarColor = requireActivity().getColor(color)
    }
}


fun Fragment.relativeSizeSpan(
    string: String,
    start: Int,
    end: Int,
    proportion: Float,
    textView: TextView
) {
    val span: Spannable = SpannableString(string)
    span.setSpan(
        RelativeSizeSpan(proportion),
        start,
        end,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    textView.text = span
}