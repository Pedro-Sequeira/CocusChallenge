package com.example.cocuschallenge.screens.challenges.authored

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocuschallenge.databinding.ItemAuthoredChallengeBinding
import com.example.cocuschallenge.models.AuthoredChallenge
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class AuthoredChallengesAdapter @Inject constructor() :
    ListAdapter<AuthoredChallenge, AuthoredChallengesAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val challenge = getItem(position)
        holder.apply {
            bind(createOnClickListener(challenge.id), challenge)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAuthoredChallengeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createOnClickListener(challengeId: String): View.OnClickListener {
        return View.OnClickListener { view ->
            val action =
                AuthoredChalengesFragmentDirections.actionAuthoredChalengesFragmentToChallengeDetailsFragment(
                    challengeId
                )
            view.findNavController().navigate(action)
        }
    }

    class ViewHolder(private val binding: ItemAuthoredChallengeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: AuthoredChallenge?) {
            binding.apply {
                clickListener = listener
                challenge = item
                executePendingBindings()
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<AuthoredChallenge>() {
        override fun areItemsTheSame(
            oldItem: AuthoredChallenge,
            newItem: AuthoredChallenge
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: AuthoredChallenge,
            newItem: AuthoredChallenge
        ): Boolean {
            return oldItem == newItem
        }
    }
}