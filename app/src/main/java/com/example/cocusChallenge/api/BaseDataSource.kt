package com.example.cocusChallenge.api

import com.example.cocusChallenge.api.models.ApiError
import com.example.cocusChallenge.data.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.Success(body)
            } else {
                val gSon = Gson()
                val type = object : TypeToken<ApiError>() {}.type
                val errorResponse: ApiError? =
                    gSon.fromJson(response.errorBody()!!.charStream(), type)
                return Result.Error(errorResponse?.reason!!)
            }
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    return Result.Error(throwable.message ?: throwable.toString())
                }
            }
        }
        return Result.Error("Error fetching network results")
    }
}