package com.example.cocusChallenge.models

import com.google.gson.annotations.SerializedName

data class AuthoredChallenge(
    @SerializedName("id")
    val id: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("rankName")
    val rankName: String?,
    @SerializedName("tags")
    val tags: List<String>
)