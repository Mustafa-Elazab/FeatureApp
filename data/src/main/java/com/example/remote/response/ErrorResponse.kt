package com.example.remote.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("status_code")
    val status_code: Int?,
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("status_message")
    val status_message: String?
)