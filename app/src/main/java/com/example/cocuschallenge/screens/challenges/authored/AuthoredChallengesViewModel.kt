package com.example.cocuschallenge.screens.challenges.authored

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocuschallenge.screens.challenges.completed.data.CompletedChallengeRepository
import com.example.cocuschallenge.models.AuthoredChallenge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AuthoredChallengesViewModel @ViewModelInject constructor(
    private val repository: CompletedChallengeRepository,
    private val scope: CoroutineScope
) : ViewModel() {

    private val _challenges = MutableLiveData<List<AuthoredChallenge>>()
    val challenges: LiveData<List<AuthoredChallenge>> = _challenges

    fun fetchCompletedChallenges(username: String) {
        scope.launch {
            val response = repository.fetchAuthoredChallenges(username)
            _challenges.postValue(response.authoredChallenges)
        }
    }
}