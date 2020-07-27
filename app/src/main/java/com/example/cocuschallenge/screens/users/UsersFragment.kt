package com.example.cocuschallenge.screens.users

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cocuschallenge.databinding.FragmentUsersBinding
import com.example.cocuschallenge.screens.challenges.ChallengesActivity
import dagger.hilt.android.AndroidEntryPoint

const val USERNAME_KEY = "username"

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private lateinit var binding: FragmentUsersBinding
    private val viewModel: UsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchUser("g964")
        binding.button.setOnClickListener {
            val intent = Intent(requireActivity(), ChallengesActivity::class.java)
            intent.putExtra(USERNAME_KEY, "g964")
            startActivity(intent)
        }
    }
}