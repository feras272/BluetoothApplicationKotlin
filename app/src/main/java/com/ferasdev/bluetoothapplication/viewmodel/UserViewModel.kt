package com.ferasdev.bluetoothapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ferasdev.bluetoothapplication.data.models.User
import com.ferasdev.bluetoothapplication.data.repositories.GetAllAdultUsersUseCase
import com.ferasdev.bluetoothapplication.data.repositories.GetAllNormalWeightUsersUseCase
import com.ferasdev.bluetoothapplication.data.repositories.UserDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userDataSource: UserDataSource,
    private val getAllAdultUsersUseCase: GetAllAdultUsersUseCase,
    private val getAllNormalWeightUsersUseCase: GetAllNormalWeightUsersUseCase
    // private val addUserToUserList: AddUserToUserListUseCase()
) : ViewModel() {

    val TAG = "UserViewModelDaggerHilt"

    // LiveData
    //private val _allUsers = MutableLiveData<List<User>>()
    //val allUsers : LiveData<List<User>> = _allUsers

    // StateFlow
    val user: User = User("ahmad", 25, 75.5, 182.8f)
    val listOfUsers = listOf<User>(user)
    private val _allUsers: MutableStateFlow<List<User>> = MutableStateFlow(listOfUsers)
    val allUsers : StateFlow<List<User>> = _allUsers

    init {
        viewModelScope.launch {
            loadNormalWeightUsers()
        }

    }

//    fun loadUsers() {
//        _allUsers.value = getAllAdultUsersUseCase.getAllAdultUsersUseCase()
//    }
suspend fun loadNormalWeightUsers() {
        _allUsers.emit(getAllNormalWeightUsersUseCase.getAllNormalWeightUsersUseCase())

    }


}