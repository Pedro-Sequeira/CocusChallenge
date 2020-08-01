package com.example.cocusChallenge.api.models

import com.example.cocusChallenge.models.AuthoredChallenge
import com.google.gson.annotations.SerializedName

data class AuthoredChallengeResponse(
    @SerializedName("data")
    val authoredChallenges: List<AuthoredChallenge>
)