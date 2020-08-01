package com.example.cocusChallenge.screens.users.data

import com.example.cocusChallenge.data.resultLiveData
import javax.inject.Inject

class UserRepository @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource) {

    fun searchUser(query: String) =
        resultLiveData {
            userRemoteDataSource.searchUser(query)
        }

}