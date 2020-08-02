package com.example.cocusChallenge.api

import com.example.cocusChallenge.api.models.ApiChallenge
import com.example.cocusChallenge.api.models.ApiUser
import com.example.cocusChallenge.database.entities.DbChallenge
import com.example.cocusChallenge.database.entities.DbUser
import java.util.*
import javax.inject.Inject

class ApiMapper @Inject constructor() {

    fun mapApiUserToDbUser(apiUser: ApiUser): DbUser {
        return with(apiUser) {
            DbUser(
                username,
                leaderBoardPosition,
                honor,
                ranks.overall.name,
                bestLanguage,
                Calendar.getInstance().timeInMillis
            )
        }
    }

    fun mapApiChallengeToDbChallenge(apiChallenge: ApiChallenge): DbChallenge {
        return with(apiChallenge) {
            DbChallenge(
                id,
                name,
                description,
                null
            )
        }
    }
}