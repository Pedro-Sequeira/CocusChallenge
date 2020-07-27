package com.example.cocuschallenge.screens.users

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocuschallenge.data.UserRepository
import com.example.cocuschallenge.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UsersViewModel @ViewModelInject constructor(
    private val repository: UserRepository,
    private val scope: CoroutineScope
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun searchUser(username: String) {
        scope.launch {
            val user = repository.searchUser(username)
            _user.postValue(user)
        }
    }
}