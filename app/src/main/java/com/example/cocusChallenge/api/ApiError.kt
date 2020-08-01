package com.example.cocusChallenge.api

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("reason")
    val reason: String,
    @SerializedName("success")
    val success: Boolean
)