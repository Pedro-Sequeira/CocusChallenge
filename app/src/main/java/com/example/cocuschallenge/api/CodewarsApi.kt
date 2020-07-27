package com.example.cocuschallenge.api

import com.example.cocuschallenge.models.CompletedChallengeResponse
import com.example.cocuschallenge.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface CodewarsApi {

    companion object {
        const val BASE_URL = "https://www.codewars.com/api/v1/"
    }

    @GET("users/{username}")
    suspend fun searchUsername(@Path("username") username: String): User

    @GET("users/{username}/code-challenges/completed?page=0")
    suspend fun fetchCompletedChallenges(@Path("username") username: String): CompletedChallengeResponse
}