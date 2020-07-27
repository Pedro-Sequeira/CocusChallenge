package com.example.cocuschallenge.api

import com.example.cocuschallenge.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface CodewarsApi {

    companion object {
        const val BASE_URL = "https://www.codewars.com/api/v1/"
    }

    @GET("users/{username}")
    suspend fun searchUsername(@Path("username") username: String): User
}