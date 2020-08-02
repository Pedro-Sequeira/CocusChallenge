package com.example.cocusChallenge.database

import com.example.cocusChallenge.database.entities.DbChallenge
import com.example.cocusChallenge.database.entities.DbUser
import com.example.cocusChallenge.database.entities.UserWithChallenges
import com.example.cocusChallenge.models.Challenge
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

    fun mapDbChallengeToChallenge(dbChallenge: DbChallenge): Challenge {
        return with(dbChallenge) {
            Challenge(
                id,
                name,
                description,
                completedAt
            )
        }
    }
}