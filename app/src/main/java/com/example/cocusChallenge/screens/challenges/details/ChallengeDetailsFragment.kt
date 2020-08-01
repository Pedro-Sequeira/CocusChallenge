package com.example.cocusChallenge.screens.challenges.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.cocusChallenge.data.Result
import com.example.cocusChallenge.databinding.FragmentChallengeDetailsBinding
import com.example.cocusChallenge.screens.challenges.completed.CompletedChallengesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChallengeDetailsFragment : Fragment() {

    private val args: ChallengeDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentChallengeDetailsBinding
    private val viewModel: ChallengeDetailsViewModel by viewModels()

    @Inject
    lateinit var adapter: CompletedChallengesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengeDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        viewModel.fetchChallengeDetails(args.challengeId)
            .observe(viewLifecycleOwner, { result ->
                when (result) {
                    is Result.Success -> {
                        binding.progressBarChallengeDetails.isVisible = false
                        viewModel.challenge.value = result.data
                    }
                    is Result.Error -> {
                        binding.progressBarChallengeDetails.isVisible = false
                        Toast.makeText(
                            requireContext(),
                            result.error,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    Result.Loading -> binding.progressBarChallengeDetails.isVisible = true
                }
            })
    }
}