package com.example.cocusChallenge.screens.challenges.data

import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cocusChallenge.api.ApiMapper
import com.example.cocusChallenge.api.CodeWarsService
import com.example.cocusChallenge.data.Result
import com.example.cocusChallenge.database.DbMapper
import com.example.cocusChallenge.database.dao.ChallengeDao
import com.example.cocusChallenge.database.dao.UserDao
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ChallengeRepository @Inject constructor(
    private val userDao: UserDao,
    private val challengeDao: ChallengeDao,
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
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val dbChallenges = userDao.getUsersWithChallenges().filter {
                    it.user.username == username
                }[0].challenges
                if (dbChallenges.isNotEmpty()) {
                    challengeDao.insertChallenges(dbChallenges)
                    emit(Result.Success(dbChallenges.map {
                        dbMapper.mapDbChallengeToChallenge(it)
                    }))
                }
                val response = challengesRemoteDataSource.fetchAuthoredChallenges(username)
                when (response) {
                    is Result.Success -> {
                        val apiChallenges = response.data!!.apiAuthoredChallenges
                        val challenges = apiChallenges.map {
                            apiMapper.mapApiAuthoredChallengeToDbChallenge(username, it)
                        }
                        challengeDao.insertChallenges(challenges)
                        emit(Result.Success(challenges.map {
                            dbMapper.mapDbChallengeToChallenge(it)
                        }))
                    }
                    is Result.Error -> {
                        emit(Result.Error(response.error))
                    }
                }
            } catch (throwable: Throwable) {
                emit(Result.Error(throwable.localizedMessage ?: "Error"))
            }
        }

    fun fetchChallengeDetails(challengeId: String) =
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val dbChallenge = challengeDao.getChallenge(challengeId)
                if (dbChallenge != null) {
                    challengeDao.insertChallenge(dbChallenge)
                    emit(Result.Success(dbMapper.mapDbChallengeToChallenge(dbChallenge)))
                }
                val response = challengesRemoteDataSource.fetchChallengeDetails(challengeId)
                when (response) {
                    is Result.Success -> {
                        val apiChallenge = response.data!!
                        challengeDao.insertChallenge(apiMapper.mapApiChallengeToDbChallenge(apiChallenge))
                        val challenge = dbMapper.mapDbChallengeToChallenge(challengeDao.getChallenge(challengeId)!!)
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