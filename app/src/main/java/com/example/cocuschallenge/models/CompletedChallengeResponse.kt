package com.example.cocuschallenge.models

import com.google.gson.annotations.SerializedName

data class CompletedChallengeResponse(
    @SerializedName("data")
    val challenges: List<Challenge>,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)