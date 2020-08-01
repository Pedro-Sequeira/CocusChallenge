package com.example.cocusChallenge.api.models

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("reason")
    val reason: String,
    @SerializedName("success")
    val success: Boolean
)