package com.example.cocusChallenge.screens.challenges.completed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocusChallenge.R
import com.example.cocusChallenge.databinding.ChallengesLoadStateFooterViewItemBinding
import com.example.cocusChallenge.screens.challenges.completed.ChallengesLoadStateAdapter.ChallengesLoadStateViewHolder

class ChallengesLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<ChallengesLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: ChallengesLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): ChallengesLoadStateViewHolder {
        return ChallengesLoadStateViewHolder.create(parent, retry)
    }

    class ChallengesLoadStateViewHolder(
        private val binding: ChallengesLoadStateFooterViewItemBinding,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.buttonFooterRetry.setOnClickListener { retry.invoke() }
        }

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.textViewFooterError.text = loadState.error.localizedMessage
            }
            binding.progressBarFooter.isVisible = loadState is LoadState.Loading
            binding.buttonFooterRetry.isVisible = loadState !is LoadState.Loading
            binding.textViewFooterError.isVisible = loadState !is LoadState.Loading
        }

        companion object {
            fun create(parent: ViewGroup, retry: () -> Unit): ChallengesLoadStateViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.challenges_load_state_footer_view_item, parent, false)
                val binding = ChallengesLoadStateFooterViewItemBinding.bind(view)
                return ChallengesLoadStateViewHolder(binding, retry)
            }
        }
    }
}