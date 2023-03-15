package com.ferasdev.bluetoothapplication.data.repositories

import com.ferasdev.bluetoothapplication.data.models.User
import javax.inject.Inject

class GetAllNormalWeightUsersUseCase
@Inject constructor(
    private val repository: Repository
){

    private val normalWeightUsers: ArrayList<User> = ArrayList()

    fun getAllNormalWeightUsersUseCase() : List<User> {

        for (user in repository.getSavedDataSource().getSavedUsers()) {
            if(isNormalWeight(user)) {
                normalWeightUsers.add(user)
            }
        }

        val _normalWeightUsers: List<User> = normalWeightUsers
        return _normalWeightUsers
    }

    fun isNormalWeight(user:User): Boolean {
        var isNormal:Boolean
        val bmi = user.userWeight / ((user.userHeight.toDouble()/100.0) * (user.userHeight.toDouble()/100.0))
        isNormal = bmi in 18.5..24.9
        return isNormal
    }

}