package com.example.cocuschallenge.api

import com.example.cocuschallenge.models.AuthoredChallengeResponse
import com.example.cocuschallenge.models.Challenge
import com.example.cocuschallenge.models.CompletedChallengeResponse
import com.example.cocuschallenge.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CodewarsApi {

    companion object {
        const val BASE_URL = "https://www.codewars.com/api/v1/"
    }

    @GET("users/{username}")
    suspend fun searchUsername(@Path("username") username: String): Response<User>

    @GET("users/{username}/code-challenges/completed?page=0")
    suspend fun fetchCompletedChallenges(@Path("username") username: String): CompletedChallengeResponse

    @GET("users/{username}/code-challenges/authored?page=0")
    suspend fun fetchAuthoredChallenges(@Path("username") username: String): AuthoredChallengeResponse

    @GET("code-challenges/{id}")
    suspend fun fetchChallengeDetails(@Path("id") id: String): Challenge
}