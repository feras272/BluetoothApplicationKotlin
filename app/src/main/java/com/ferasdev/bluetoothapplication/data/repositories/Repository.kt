package com.ferasdev.bluetoothapplication.data.repositories

import javax.inject.Inject

class Repository @Inject constructor(
    private val userDataSource: UserDataSource,
    private val userLocalDataSource: UserLocalDataSource
) {

    fun getDataSource(isConnected: Boolean): UserDataSource {
//        if(isConnected) {
//            return userDataSource
//        }
        return userDataSource
    }

    fun getSavedDataSource() : UserLocalDataSource {
        return userLocalDataSource
    }
}