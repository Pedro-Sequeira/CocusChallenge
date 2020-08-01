package com.example.cocusChallenge.screens.users.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.cocusChallenge.api.ApiMapper
import com.example.cocusChallenge.data.Result
import com.example.cocusChallenge.database.DbMapper
import com.example.cocusChallenge.database.UserDao
import com.example.cocusChallenge.models.User
import kotlinx.coroutines.Dispatchers
import java.util.*
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val dao: UserDao,
    private val userRemoteDataSource: UserRemoteDataSource,
    private val apiMapper: ApiMapper,
    private val dbMapper: DbMapper
) {

    fun searchUser(query: String): LiveData<Result<List<User>>> {
        return liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val dbUser = dao.getUser(query)
                if (dbUser != null) {
                    dbUser.searchDate = Calendar.getInstance().timeInMillis
                    dao.insertUser(dbUser)
                    emit(Result.Success(dao.getUsers()!!.map {
                        dbMapper.mapDbUserToUser(it)
                    }))
                }
                val response = userRemoteDataSource.searchUser(query)
                when (response) {
                    is Result.Success -> {
                        val apiUser = response.data!!
                        dao.insertUser(apiMapper.mapApiUserToDbUser(apiUser))
                        emit(Result.Success(dao.getUsers()!!.map {
                            dbMapper.mapDbUserToUser(it)
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
    }

    fun fetchUsers(): LiveData<List<User>> =
        liveData(Dispatchers.IO) {
            val dbUsers = dao.getUsers()
            if (dbUsers != null) {
                emit(dbUsers.map {
                    dbMapper.mapDbUserToUser(it)
                })
            }
        }

    fun usersByRank(): LiveData<List<User>> =
        liveData(Dispatchers.IO) {
            val dbUsers = dao.getUsersByRank()
            if (dbUsers != null) {
                emit(dbUsers.map {
                    dbMapper.mapDbUserToUser(it)
                })
            }
        }
}