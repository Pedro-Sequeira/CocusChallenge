package com.example.cocuschallenge.models

import com.google.gson.annotations.SerializedName

data class AuthoredChallengeResponse(
    @SerializedName("data")
    val authoredChallenges: List<AuthoredChallenge>
)