package com.example.cocuschallenge.api

import com.example.cocuschallenge.data.Result
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.Success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (exception: Exception) {
            return error(exception.message ?: exception.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        return Result.Error("Network call has failed for a following reason: $message")
    }

}