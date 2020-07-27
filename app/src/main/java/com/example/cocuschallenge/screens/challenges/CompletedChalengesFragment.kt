package com.example.cocuschallenge.screens.challenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.cocuschallenge.databinding.FragmentChallengesCompletedBinding
import com.example.cocuschallenge.databinding.FragmentUsersBinding
import com.example.cocuschallenge.screens.users.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CompletedChalengesFragment : Fragment() {

    private val args: CompletedChalengesFragmentArgs by navArgs()
    private lateinit var binding: FragmentChallengesCompletedBinding
    private val viewModel: CompletedChallengesViewModel by viewModels()

    @Inject
    lateinit var adapter: CompletedChallengesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengesCompletedBinding.inflate(inflater)
        binding.viewModel = viewModel
        initAdapter()
        viewModel.fetchCompletedChallenges(args.username)
        return binding.root
    }

    private fun initAdapter() {
        binding.challengesList.adapter = adapter
        viewModel.challenges.observe(viewLifecycleOwner, Observer { challenges ->
            adapter.submitList(challenges)
        })
    }
}