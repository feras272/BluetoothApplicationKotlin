package com.ferasdev.bluetoothapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ferasdev.bluetoothapplication.data.models.User
import com.ferasdev.bluetoothapplication.data.repositories.GetAllAdultUsersUseCase
import com.ferasdev.bluetoothapplication.data.repositories.GetAllNormalWeightUsersUseCase
import com.ferasdev.bluetoothapplication.data.repositories.UserDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userDataSource: UserDataSource,
    private val getAllAdultUsersUseCase: GetAllAdultUsersUseCase,
    private val getAllNormalWeightUsersUseCase: GetAllNormalWeightUsersUseCase
    // private val addUserToUserList: AddUserToUserListUseCase()
) : ViewModel() {

    val TAG = "UserViewModelDaggerHilt"

    private val _allUsers = MutableLiveData<List<User>>()
    val allUsers : LiveData<List<User>> = _allUsers

    init {
        loadNormalWeightUsers()
    }

//    fun loadUsers() {
//        _allUsers.value = getAllAdultUsersUseCase.getAllAdultUsersUseCase()
//    }
    fun loadNormalWeightUsers() {
        _allUsers.value = getAllNormalWeightUsersUseCase.getAllNormalWeightUsersUseCase()
    }


}