package com.example.cocuschallenge.screens.challenges.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocuschallenge.screens.challenges.completed.data.CompletedChallengeRepository
import com.example.cocuschallenge.models.Challenge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ChallengeDetailsViewModel @ViewModelInject constructor(
    private val repository: CompletedChallengeRepository,
    private val scope: CoroutineScope
) : ViewModel() {

    private val _challenge = MutableLiveData<Challenge>()
    val challenge: LiveData<Challenge> = _challenge

    fun fetchChallengeDetails(id: String) {
        scope.launch {
            val response = repository.fetchChallengeDetails(id)
            _challenge.postValue(response)
        }
    }
}