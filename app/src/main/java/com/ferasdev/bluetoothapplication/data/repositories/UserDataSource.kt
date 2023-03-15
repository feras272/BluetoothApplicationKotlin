package com.ferasdev.bluetoothapplication.data.repositories

import com.ferasdev.bluetoothapplication.data.models.User

interface UserDataSource {

    fun getUsers(): List<User>
}