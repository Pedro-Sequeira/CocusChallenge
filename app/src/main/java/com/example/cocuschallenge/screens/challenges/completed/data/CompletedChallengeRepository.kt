package com.example.cocuschallenge.screens.challenges.completed.data

import com.example.cocuschallenge.api.CodewarsApi
import javax.inject.Inject

class CompletedChallengeRepository @Inject constructor(private val service: CodewarsApi) {
    suspend fun fetchCompletedChallenges(username: String) =
        service.fetchCompletedChallenges(username)

    suspend fun fetchAuthoredChallenges(username: String) =
        service.fetchAuthoredChallenges(username)

    suspend fun fetchChallengeDetails(challengeId: String) = service.fetchChallengeDetails(challengeId)
}