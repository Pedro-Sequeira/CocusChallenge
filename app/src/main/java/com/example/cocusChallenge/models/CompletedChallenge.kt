package com.example.cocusChallenge.models

import com.google.gson.annotations.SerializedName

data class CompletedChallenge(
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