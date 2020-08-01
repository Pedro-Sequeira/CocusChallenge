package com.example.cocusChallenge.screens.challenges.authored

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.cocusChallenge.screens.challenges.data.ChallengeRepository

class AuthoredChallengesViewModel @ViewModelInject constructor(
    private val repository: ChallengeRepository
) : ViewModel() {

    fun fetchAuthoredChallenges(username: String) =
        repository.fetchAuthoredChallenges(username)
}