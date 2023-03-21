package com.ferasdev.bluetoothapplication.data.repositories

import com.ferasdev.bluetoothapplication.data.models.User

class UserLocalDataSourceImpl: UserLocalDataSource {

    override suspend fun getSavedUsers(): List<User> = listOf(
        User("Feras",18,80.0,177.65f),
        User("Nasser",33,79.75,177.65f),
        User("Ahmad",20,70.50,177.65f),
        User("Khalid",34,50.60,177.65f),
        User("Abdullah",36,130.25,177.65f)
    )


}