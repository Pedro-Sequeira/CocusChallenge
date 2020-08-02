package com.example.cocusChallenge.screens.challenges.completed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cocusChallenge.databinding.ItemCompletedChallengeBinding
import com.example.cocusChallenge.models.CompletedChallenge
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class CompletedChallengesAdapter @Inject constructor() :
    PagingDataAdapter<CompletedChallenge, CompletedChallengesAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val challenge = getItem(position)
        holder.apply {
            bind(createOnClickListener(challenge?.id), challenge)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCompletedChallengeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createOnClickListener(challengeId: String?): View.OnClickListener {
        return View.OnClickListener { view ->
            challengeId?.let {
                val action =
                    CompletedChallengesFragmentDirections.actionCompletedChalengesFragmentToChallengeDetailsFragment(
                        challengeId
                    )
                view.findNavController().navigate(action)
            }
        }
    }

    class ViewHolder(private val binding: ItemCompletedChallengeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: CompletedChallenge?) {
            binding.apply {
                clickListener = listener
                challenge = item
                executePendingBindings()
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<CompletedChallenge>() {
        override fun areItemsTheSame(oldItem: CompletedChallenge, newItem: CompletedChallenge)
                : Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CompletedChallenge, newItem: CompletedChallenge)
                : Boolean {
            return oldItem == newItem
        }
    }
}