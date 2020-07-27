package com.example.cocuschallenge.screens.challenges

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocuschallenge.databinding.ItemCompletedChallengeBinding
import com.example.cocuschallenge.models.Challenge
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class CompletedChallengesAdapter @Inject constructor() :
    ListAdapter<Challenge, CompletedChallengesAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val challenge = getItem(position)
        holder.apply {
            bind(challenge)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCompletedChallengeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class ViewHolder(private val binding: ItemCompletedChallengeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Challenge?) {
            binding.apply {
                challenge = item
                executePendingBindings()
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Challenge>() {

        override fun areItemsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
            return oldItem == newItem
        }
    }
}