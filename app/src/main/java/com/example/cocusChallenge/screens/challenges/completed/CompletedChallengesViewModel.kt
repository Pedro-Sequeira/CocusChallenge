package com.example.cocusChallenge.screens.challenges.completed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cocusChallenge.api.models.ApiCompletedChallenge
import com.example.cocusChallenge.screens.challenges.data.ChallengeRepository
import kotlinx.coroutines.flow.Flow

class CompletedChallengesViewModel @ViewModelInject constructor(
    private val repository: ChallengeRepository
) : ViewModel() {

    fun fetchCompletedChallenges(username: String): Flow<PagingData<ApiCompletedChallenge>> {
        return repository.fetchCompletedChallenges(username)
            .cachedIn(viewModelScope)
    }
}