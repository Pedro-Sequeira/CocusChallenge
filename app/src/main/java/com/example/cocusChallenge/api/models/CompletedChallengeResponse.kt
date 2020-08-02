package com.example.cocusChallenge.api.models

import com.google.gson.annotations.SerializedName

data class CompletedChallengeResponse(
    @SerializedName("data")
    val apiCompletedChallenges: List<ApiCompletedChallenge>,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)