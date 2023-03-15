package com.ferasdev.bluetoothapplication.data.repositories

import com.ferasdev.bluetoothapplication.data.models.User

interface UserLocalDataSource {

    fun getSavedUsers() : List<User>
}