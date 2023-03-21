package com.ferasdev.bluetoothapplication.data.repositories

import com.ferasdev.bluetoothapplication.data.models.User

interface UserLocalDataSource {

    suspend fun getSavedUsers() : List<User>
}