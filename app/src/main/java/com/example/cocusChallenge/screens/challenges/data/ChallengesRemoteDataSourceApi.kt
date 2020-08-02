package com.example.cocusChallenge.screens.challenges.data

import com.example.cocusChallenge.api.ApiBaseDataSource
import com.example.cocusChallenge.api.CodeWarsService
import javax.inject.Inject

class ChallengesRemoteDataSourceApi @Inject constructor(private val service: CodeWarsService) :
    ApiBaseDataSource() {

    suspend fun fetchAuthoredChallenges(username: String) = getResult {
        service.fetchAuthoredChallenges(username)
    }

    suspend fun fetchChallengeDetails(challengeId: String) = getResult {
        service.fetchChallengeDetails(challengeId)
    }
}