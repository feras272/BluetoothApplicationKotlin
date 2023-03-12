package com.ferasdev.bluetoothapplication.data.repositories

import com.ferasdev.bluetoothapplication.data.models.User

interface UserRepository {

    fun getUsers(): List<User>
}