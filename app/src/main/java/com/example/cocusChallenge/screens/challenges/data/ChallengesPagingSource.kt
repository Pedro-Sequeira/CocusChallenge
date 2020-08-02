package com.example.cocusChallenge.screens.challenges.data

import androidx.paging.PagingSource
import com.example.cocusChallenge.api.CodeWarsService
import com.example.cocusChallenge.api.models.ApiCompletedChallenge
import retrofit2.HttpException
import java.io.IOException

private const val CODE_WARS_STARTING_PAGE_INDEX = 0

class CompletedChallengesPagingSource(
    private val service: CodeWarsService,
    private val username: String
) : PagingSource<Int, ApiCompletedChallenge>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ApiCompletedChallenge> {
        val position = params.key ?: CODE_WARS_STARTING_PAGE_INDEX
        return try {
            val response = service.fetchCompletedChallenges(username, position)
            val challenges = response.apiCompletedChallenges
            LoadResult.Page(
                data = challenges,
                prevKey = if (position == CODE_WARS_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.totalPages == position) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}