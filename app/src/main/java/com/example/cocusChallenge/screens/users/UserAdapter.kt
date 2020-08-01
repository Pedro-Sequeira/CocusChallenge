package com.example.cocusChallenge.screens.users

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocusChallenge.databinding.ItemUserBinding
import com.example.cocusChallenge.models.User
import com.example.cocusChallenge.screens.challenges.ChallengesActivity
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class UserAdapter @Inject constructor() :
    ListAdapter<User, UserAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favorite = getItem(position)
        holder.apply {
            bind(createOnClickListener(favorite), favorite)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    private fun createOnClickListener(user: User): View.OnClickListener {
        return View.OnClickListener {
            val intent = Intent(it.context, ChallengesActivity::class.java)
            intent.putExtra(USERNAME_KEY, user.username)
            it.context.startActivity(intent)
        }
    }

    class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: User) {
            binding.apply {
                clickListener = listener
                user = item
                executePendingBindings()
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.username == newItem.username
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}