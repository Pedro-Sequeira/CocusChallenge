package com.example.cocusChallenge.models

import com.google.gson.annotations.SerializedName

data class CompletedChallengeResponse(
    @SerializedName("data")
    val completedChallenges: List<CompletedChallenge>,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)