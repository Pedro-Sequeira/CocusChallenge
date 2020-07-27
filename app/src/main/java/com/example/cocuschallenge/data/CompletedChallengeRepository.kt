package com.example.cocuschallenge.data

import com.example.cocuschallenge.api.CodewarsApi
import javax.inject.Inject

class CompletedChallengeRepository @Inject constructor(private val service: CodewarsApi) {
    suspend fun fetchCompletedChallenges(username: String) =
        service.fetchCompletedChallenges(username)
}