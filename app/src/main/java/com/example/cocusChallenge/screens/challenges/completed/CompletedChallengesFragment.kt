package com.example.cocusChallenge.screens.challenges.completed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.cocusChallenge.databinding.FragmentChallengesCompletedBinding
import com.example.cocusChallenge.screens.challenges.ChallengesActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CompletedChallengesFragment : Fragment() {

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
        (requireActivity() as ChallengesActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as ChallengesActivity
        initAdapter(activity)
        lifecycleScope.launch {
            viewModel.fetchCompletedChallenges(activity.username).collectLatest {
                adapter.submitData(it)
            }
        }
        binding.buttonCompletedChallengesRetry.setOnClickListener { adapter.retry() }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            requireActivity().finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initAdapter(activity: ChallengesActivity) {
        binding.challengesList.adapter = adapter.withLoadStateHeaderAndFooter(
            header = ChallengesLoadStateAdapter { adapter.retry() },
            footer = ChallengesLoadStateAdapter { adapter.retry() }
        )
        adapter.addLoadStateListener { loadState ->
            binding.challengesList.isVisible = loadState.source.refresh is LoadState.NotLoading
            binding.progressBarCompletedChallenges.isVisible = loadState.source.refresh is LoadState.Loading
            binding.buttonCompletedChallengesRetry.isVisible = loadState.source.refresh is LoadState.Error

            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error
            errorState?.let {
                Toast.makeText(
                    activity,
                    "\uD83D\uDE28 Wooops ${it.error}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}