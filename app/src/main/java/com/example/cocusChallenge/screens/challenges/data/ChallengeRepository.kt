package com.example.cocusChallenge.screens.challenges.data

import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cocusChallenge.api.ApiMapper
import com.example.cocusChallenge.api.CodeWarsService
import com.example.cocusChallenge.data.Result
import com.example.cocusChallenge.data.resultLiveData
import com.example.cocusChallenge.database.DbMapper
import com.example.cocusChallenge.database.dao.ChallengeDao
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ChallengeRepository @Inject constructor(
    private val dao: ChallengeDao,
    private val challengesRemoteDataSource: ChallengesRemoteDataSourceApi,
    private val service: CodeWarsService,
    private val apiMapper: ApiMapper,
    private val dbMapper: DbMapper
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
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val dbChallenge = dao.getChallenge(challengeId)
                if (dbChallenge != null) {
                    dao.insertChallenge(dbChallenge)
                    emit(Result.Success(dbMapper.mapDbChallengeToChallenge(dbChallenge)))
                }
                val response = challengesRemoteDataSource.fetchChallengeDetails(challengeId)
                when (response) {
                    is Result.Success -> {
                        val apiChallenge = response.data!!
                        dao.insertChallenge(apiMapper.mapApiChallengeToDbChallenge(apiChallenge))
                        val challenge = dbMapper.mapDbChallengeToChallenge(dao.getChallenge(challengeId)!!)
                        emit(Result.Success(challenge))
                    }
                    is Result.Error -> {
                        emit(Result.Error(response.error))
                    }
                }
            } catch (throwable: Throwable) {
                emit(Result.Error(throwable.localizedMessage ?: "Error"))
            }
        }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}