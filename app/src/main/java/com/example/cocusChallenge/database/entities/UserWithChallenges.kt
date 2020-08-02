package com.example.cocusChallenge.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cocusChallenge.models.User

data class UserWithChallenges(
    @Embedded val user: DbUser,
    @Relation(
        parentColumn = "username",
        entityColumn = "user"
    )
    val challenges: List<DbChallenge>
)