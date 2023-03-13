package com.ferasdev.bluetoothapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ferasdev.bluetoothapplication.data.models.User
import com.ferasdev.bluetoothapplication.data.repositories.UserRepository
import com.ferasdev.bluetoothapplication.data.repositories.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val TAG = "MainViewModelDaggerHilt"

    private val _allUsers = MutableLiveData<List<User>>()
    val allUsers : LiveData<List<User>> = _allUsers

    init {
        loadUsers()
    }

    private fun loadUsers() {
        _allUsers.value = userRepository.getUsers()
    }
}