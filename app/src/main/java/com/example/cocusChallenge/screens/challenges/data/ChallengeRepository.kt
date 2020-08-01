package com.example.cocusChallenge.screens.challenges.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cocusChallenge.api.CodeWarsService
import com.example.cocusChallenge.data.resultLiveData
import javax.inject.Inject

class ChallengeRepository @Inject constructor(
    private val challengesRemoteDataSource: ChallengesRemoteDataSource,
    private val service: CodeWarsService
) {
    fun fetchCompletedChallenges(username: String) =
        Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CompletedChallengesPagingSource(service, username)
            }
        ).flow

    fun fetchAuthoredChallenges(username: String) =
        resultLiveData {
            challengesRemoteDataSource.fetchAuthoredChallenges(username)
        }

    fun fetchChallengeDetails(challengeId: String) =
        resultLiveData {
            challengesRemoteDataSource.fetchChallengeDetails(challengeId)
        }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}