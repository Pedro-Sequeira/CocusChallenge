package com.example.cocusChallenge.screens.challenges.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocusChallenge.models.Challenge
import com.example.cocusChallenge.screens.challenges.data.ChallengeRepository

class ChallengeDetailsViewModel @ViewModelInject constructor(
    private val repository: ChallengeRepository
) : ViewModel() {

    val challenge = MutableLiveData<Challenge>()

    fun fetchChallengeDetails(challengeId: String) =
        repository.fetchChallengeDetails(challengeId)
}