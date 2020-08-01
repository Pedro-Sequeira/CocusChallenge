package com.example.cocusChallenge.screens.challenges.data

import androidx.paging.PagingSource
import com.example.cocusChallenge.api.CodeWarsService
import com.example.cocusChallenge.models.CompletedChallenge
import retrofit2.HttpException
import java.io.IOException

private const val CODE_WARS_STARTING_PAGE_INDEX = 0

class CompletedChallengesPagingSource(
    private val service: CodeWarsService,
    private val username: String
) : PagingSource<Int, CompletedChallenge>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CompletedChallenge> {
        val position = params.key ?: CODE_WARS_STARTING_PAGE_INDEX
        return try {
            val response = service.fetchCompletedChallenges(username, position)
            val challenges = response.completedChallenges
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