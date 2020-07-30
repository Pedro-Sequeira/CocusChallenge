package com.example.cocuschallenge.screens.challenges.completed.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocuschallenge.screens.challenges.completed.data.CompletedChallengeRepository
import com.example.cocuschallenge.models.CompletedChallenge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CompletedChallengesViewModel @ViewModelInject constructor(
    private val repository: CompletedChallengeRepository,
    private val scope: CoroutineScope
) : ViewModel() {

    private val _challenges = MutableLiveData<List<CompletedChallenge>>()
    val challenges: LiveData<List<CompletedChallenge>> = _challenges

    fun fetchCompletedChallenges(username: String) {
        scope.launch {
            val response = repository.fetchCompletedChallenges(username)
            _challenges.postValue(response.completedChallenges)
        }
    }
}