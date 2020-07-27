package com.example.cocuschallenge.data

import com.example.cocuschallenge.api.CodewarsApi
import javax.inject.Inject

class UserRepository @Inject constructor(private val service: CodewarsApi) {
    suspend fun searchUser(username: String) = service.searchUsername(username)
}