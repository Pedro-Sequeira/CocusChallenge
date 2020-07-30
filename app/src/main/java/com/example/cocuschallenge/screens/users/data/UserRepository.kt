package com.example.cocuschallenge.screens.users.data

import com.example.cocuschallenge.data.resultLiveData
import javax.inject.Inject

class UserRepository @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource) {

    fun searchUser(query: String) =
        resultLiveData {
            userRemoteDataSource.searchUser(query)
        }

}