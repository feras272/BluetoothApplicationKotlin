package com.ferasdev.bluetoothapplication.data.repositories

import com.ferasdev.bluetoothapplication.data.models.User


class UserRepositoryImpl: UserRepository {
//    private val userList:ArrayList<User> = ArrayList()
//    override fun getUsers(): List<User> {
//        userList.add(User("Feras",24,80.0,177.65f))
//        userList.add(User("Nasser",33,79.75,177.65f))
//        userList.add(User("Ahmad",27,70.50,177.65f))
//        userList.add(User("Khalid",34,67.60,177.65f))
//        userList.add(User("Abdullah",36,88.25,177.65f))
//        return userList
//    }

    private val userList:ArrayList<User> = ArrayList()
    override fun getUsers() = listOf(
        User("Feras",24,80.0,177.65f),
        User("Nasser",33,79.75,177.65f),
        User("Ahmad",27,70.50,177.65f),
        User("Khalid",34,67.60,177.65f),
        User("Abdullah",36,88.25,177.65f)
    )




}