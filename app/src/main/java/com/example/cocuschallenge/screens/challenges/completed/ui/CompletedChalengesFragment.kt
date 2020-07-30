package com.example.cocuschallenge.screens.challenges.completed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.cocuschallenge.databinding.FragmentChallengesCompletedBinding
import com.example.cocuschallenge.screens.challenges.ChallengesActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CompletedChalengesFragment : Fragment() {

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as ChallengesActivity
        viewModel.fetchCompletedChallenges(activity.username)
    }

    private fun initAdapter() {
        binding.challengesList.adapter = adapter
        viewModel.challenges.observe(viewLifecycleOwner, Observer { challenges ->
            adapter.submitList(challenges)
        })
    }
}