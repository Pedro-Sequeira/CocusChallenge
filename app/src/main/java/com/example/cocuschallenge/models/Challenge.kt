package com.example.cocuschallenge.models

import com.google.gson.annotations.SerializedName

data class Challenge(
    @SerializedName("id")
    val id: String,
    @SerializedName("approvedAt")
    val approvedAt: String,
    @SerializedName("approvedBy")
    val approvedBy: ApprovedBy,
    @SerializedName("category")
    val category: String,
    @SerializedName("contributorsWanted")
    val contributorsWanted: Boolean,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("createdBy")
    val createdBy: CreatedBy,
    @SerializedName("description")
    val description: String,
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("rank")
    val rank: Rank,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("totalAttempts")
    val totalAttempts: Int,
    @SerializedName("totalCompleted")
    val totalCompleted: Int,
    @SerializedName("totalStars")
    val totalStars: Int,
    @SerializedName("unresolved")
    val unresolved: Unresolved,
    @SerializedName("url")
    val url: String,
    @SerializedName("voteScore")
    val voteScore: Int
) {
    data class ApprovedBy(
        @SerializedName("url")
        val url: String,
        @SerializedName("username")
        val username: String
    )

    data class CreatedBy(
        @SerializedName("url")
        val url: String,
        @SerializedName("username")
        val username: String
    )

    data class Rank(
        @SerializedName("color")
        val color: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )

    data class Unresolved(
        @SerializedName("issues")
        val issues: Int,
        @SerializedName("suggestions")
        val suggestions: Int
    )
}