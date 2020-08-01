package com.example.cocusChallenge.screens.users.data

import com.example.cocusChallenge.api.BaseDataSource
import com.example.cocusChallenge.api.CodeWarsService
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val service: CodeWarsService) :
    BaseDataSource() {

    suspend fun searchUser(query: String) = getResult {
        service.searchUsername(query)
    }
}