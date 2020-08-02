package com.example.cocusChallenge.screens.challenges.authored

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cocusChallenge.data.Result
import com.example.cocusChallenge.databinding.FragmentChallengesAuthoredBinding
import com.example.cocusChallenge.screens.challenges.ChallengesActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthoredChalengesFragment : Fragment() {

    private lateinit var binding: FragmentChallengesAuthoredBinding
    private val viewModel: AuthoredChallengesViewModel by viewModels()

    @Inject
    lateinit var adapter: AuthoredChallengesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengesAuthoredBinding.inflate(inflater)
        binding.viewModel = viewModel
        (requireActivity() as ChallengesActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as ChallengesActivity
        initAdapter(activity)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            requireActivity().finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initAdapter(activity: ChallengesActivity) {
        binding.recyclerViewAuthoredChallenges.adapter = adapter

        viewModel.fetchAuthoredChallenges(activity.username)
            .observe(viewLifecycleOwner, { result ->
                when (result) {
                    is Result.Success -> {
                        binding.progressBarAuthoredChallenges.isVisible = false
                        adapter.submitList(result.data?.apiAuthoredChallenges)
                    }
                    is Result.Error -> {
                        binding.progressBarAuthoredChallenges.isVisible = false
                        Toast.makeText(
                            requireContext(),
                            result.error,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    Result.Loading -> binding.progressBarAuthoredChallenges.isVisible = true
                }
            })
    }
}