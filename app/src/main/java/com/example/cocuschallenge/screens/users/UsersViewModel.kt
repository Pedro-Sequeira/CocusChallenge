package com.example.cocuschallenge.screens.users

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.cocuschallenge.screens.users.data.UserRepository

class UsersViewModel @ViewModelInject constructor(private val repository: UserRepository) :
    ViewModel() {

    fun searchUser(query: String) = repository.searchUser(query)
}