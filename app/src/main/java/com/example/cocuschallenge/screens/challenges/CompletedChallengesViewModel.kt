package com.example.cocuschallenge.screens.challenges

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocuschallenge.data.CompletedChallengeRepository
import com.example.cocuschallenge.models.Challenge
import com.example.cocuschallenge.models.CompletedChallengeResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CompletedChallengesViewModel @ViewModelInject constructor(
    private val repository: CompletedChallengeRepository,
    private val scope: CoroutineScope
) : ViewModel() {

    private val _challenges = MutableLiveData<List<Challenge>>()
    val challenges: LiveData<List<Challenge>> = _challenges

    fun fetchCompletedChallenges(username: String) {
        scope.launch {
            val response = repository.fetchCompletedChallenges(username)
            _challenges.postValue(response.challenges)
        }
    }
}