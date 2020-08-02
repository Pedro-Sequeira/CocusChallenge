package com.example.cocusChallenge.screens.challenges.authored

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cocusChallenge.models.Challenge
import com.example.cocusChallenge.screens.challenges.data.ChallengeRepository
import com.example.cocusChallenge.data.Result

class AuthoredChallengesViewModel @ViewModelInject constructor(
    private val repository: ChallengeRepository
) : ViewModel() {

    fun fetchAuthoredChallenges(username: String): LiveData<Result<List<Challenge>>> =
        repository.fetchAuthoredChallenges(username)
}