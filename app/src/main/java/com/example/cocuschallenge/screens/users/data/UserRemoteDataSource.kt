package com.example.cocuschallenge.screens.users.data

import com.example.cocuschallenge.api.BaseDataSource
import com.example.cocuschallenge.api.CodewarsApi
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val service: CodewarsApi) :
    BaseDataSource() {

    suspend fun searchUser(query: String) = getResult {
        service.searchUsername(query)
    }
}