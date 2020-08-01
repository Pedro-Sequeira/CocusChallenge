package com.example.cocusChallenge.api

import com.example.cocusChallenge.api.models.AuthoredChallengeResponse
import com.example.cocusChallenge.models.Challenge
import com.example.cocusChallenge.api.models.CompletedChallengeResponse
import com.example.cocusChallenge.api.models.ApiUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodeWarsService {

    @GET("users/{username}")
    suspend fun searchUsername(@Path("username") username: String): Response<ApiUser>

    @GET("users/{username}/code-challenges/completed")
    suspend fun fetchCompletedChallenges(
        @Path("username") username: String,
        @Query("page") page: Int
    ): CompletedChallengeResponse

    @GET("users/{username}/code-challenges/authored")
    suspend fun fetchAuthoredChallenges(@Path("username") username: String): Response<AuthoredChallengeResponse>

    @GET("code-challenges/{id}")
    suspend fun fetchChallengeDetails(@Path("id") id: String): Response<Challenge>
}