package com.example.cocuschallenge.screens.users

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.cocuschallenge.data.Result
import com.example.cocuschallenge.databinding.FragmentUsersBinding
import com.example.cocuschallenge.screens.challenges.ChallengesActivity
import com.example.cocuschallenge.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint

const val USERNAME_KEY = "username"

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private lateinit var binding: FragmentUsersBinding
    private val viewModel: UsersViewModel by viewModels()

    private var query: String? = null

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

        query = savedInstanceState?.getString(LAST_SEARCH_QUERY)
        binding.editTextUsername.setText(query)

        initEditTextListeners()

        binding.button.setOnClickListener {
            val intent = Intent(requireActivity(), ChallengesActivity::class.java)
            intent.putExtra(USERNAME_KEY, binding.editTextUsername.text.toString())
            startActivity(intent)
        }
    }

    private fun initEditTextListeners() {
        binding.editTextUsername.setOnEditorActionListener { view, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                updateRepoListFromInput()
                view.hideKeyboard()
                true
            } else {
                false
            }
        }
        binding.editTextUsername.setOnKeyListener { view, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                view.hideKeyboard()
                updateRepoListFromInput()
                true
            } else {
                false
            }
        }
        binding.editTextUsername.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.textInputUsername.error = null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(
            LAST_SEARCH_QUERY,
            binding.textInputUsername.editText?.text.toString()
        )
    }

    private fun updateRepoListFromInput() {
        binding.editTextUsername.text?.trim().let {
            if (!it.isNullOrEmpty()) {
                searchCharacters(it.toString())
            } else {
                binding.textInputUsername.error = "You've to type something first"
            }
        }
    }

    private fun searchCharacters(query: String) {
        viewModel.searchUser(query).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Success -> {
                    binding.progressBarUsers.isVisible = false
                    binding.username.text = result.data.username
                }
                is Result.Error -> {
                    binding.progressBarUsers.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        result.error,
                        Toast.LENGTH_LONG
                    ).show()
                }
                Result.Loading -> binding.progressBarUsers.isVisible = true
            }
        })
    }

    companion object {
        private const val LAST_SEARCH_QUERY: String = "last_search_query"
    }
}