package com.example.cocuschallenge.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

fun <T> resultLiveData(networkCall: suspend () -> Result<T>): LiveData<Result<T>> =
    liveData(Dispatchers.IO) {
        emit(Result.Loading)
        val response = networkCall.invoke()
        when (response) {
            is Result.Success -> {
                emit(Result.Success(response.data) as Result<T>)
            }
            is Result.Error -> {
                emit(Result.Error(response.error))
            }
        }
    }