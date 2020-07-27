package com.example.cocuschallenge.screens.challenges.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.cocuschallenge.databinding.FragmentChallengeDetailsBinding
import com.example.cocuschallenge.screens.challenges.completed.CompletedChallengesAdapter
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
        viewModel.fetchChallengeDetails(args.id)
    }
}