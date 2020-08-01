package com.example.cocusChallenge.database

import com.example.cocusChallenge.models.User
import javax.inject.Inject

class DbMapper @Inject constructor() {

    fun mapDbUserToUser(dbUser: DbUser): User {
        return with(dbUser) {
            User(
                username,
                honor,
                rankName,
                leaderBoardPosition,
                bestLanguage
            )
        }
    }
}