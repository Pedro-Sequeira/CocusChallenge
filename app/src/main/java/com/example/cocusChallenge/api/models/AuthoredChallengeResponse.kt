package com.example.cocusChallenge.api.models

import com.google.gson.annotations.SerializedName

data class AuthoredChallengeResponse(
    @SerializedName("data")
    val apiAuthoredChallenges: List<ApiAuthoredChallenge>
)