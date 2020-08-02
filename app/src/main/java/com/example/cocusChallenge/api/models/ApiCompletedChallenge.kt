package com.example.cocusChallenge.api.models

import com.google.gson.annotations.SerializedName

data class ApiCompletedChallenge(
    @SerializedName("id")
    val id: String,
    @SerializedName("completedAt")
    val completedAt: String,
    @SerializedName("completedLanguages")
    val completedLanguages: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)