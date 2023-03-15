package com.ferasdev.bluetoothapplication.data.repositories

import com.ferasdev.bluetoothapplication.data.models.User
import javax.inject.Inject

class GetAllAdultUsersUseCase
@Inject constructor(
    private val repository: Repository
){

    private val adultUsersList: ArrayList<User> = ArrayList()

    fun getAllAdultUsersUseCase(): List<User> {
        for (user in repository.getSavedDataSource().getSavedUsers()) {
            if(user.userAge >= 21) {
                adultUsersList.add(user)
            }
        }
        val _adultUserList: List<User> = adultUsersList
        return _adultUserList
    }

}