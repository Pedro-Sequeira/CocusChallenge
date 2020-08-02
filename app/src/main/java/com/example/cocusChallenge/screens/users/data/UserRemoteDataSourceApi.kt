package com.example.cocusChallenge.screens.users.data

import com.example.cocusChallenge.api.ApiBaseDataSource
import com.example.cocusChallenge.api.CodeWarsService
import javax.inject.Inject

class UserRemoteDataSourceApi @Inject constructor(private val service: CodeWarsService) :
    ApiBaseDataSource() {

    suspend fun searchUser(query: String) = getResult {
        service.searchUsername(query)
    }
}