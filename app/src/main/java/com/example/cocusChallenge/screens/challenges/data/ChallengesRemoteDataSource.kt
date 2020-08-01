package com.example.cocusChallenge.screens.challenges.data

import com.example.cocusChallenge.api.BaseDataSource
import com.example.cocusChallenge.api.CodeWarsService
import javax.inject.Inject

class ChallengesRemoteDataSource @Inject constructor(private val service: CodeWarsService) :
    BaseDataSource() {

    suspend fun fetchAuthoredChallenges(username: String) = getResult {
        service.fetchAuthoredChallenges(username)
    }

    suspend fun fetchChallengeDetails(challengeId: String) = getResult {
        service.fetchChallengeDetails(challengeId)
    }
}