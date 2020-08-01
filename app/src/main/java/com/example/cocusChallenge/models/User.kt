package com.example.cocusChallenge.models

data class User(
    val username: String,
    val honor: Int,
    val rankName: String,
    val leaderBoardPosition: Int?,
    val bestLanguage: String?
)