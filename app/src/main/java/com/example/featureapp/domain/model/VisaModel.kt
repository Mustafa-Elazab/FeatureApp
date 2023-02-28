package com.example.featureapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class VisaModel(
    val bankName: String,

    val cardHolder: String,

    val cardNumber: String,

    val expiryDate: String,

    val cvv: String?,

    )  : Parcelable
