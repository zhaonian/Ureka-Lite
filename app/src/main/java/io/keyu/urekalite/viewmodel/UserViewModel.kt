package io.keyu.urekalite.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.keyu.urekalite.model.Resource
import io.keyu.urekalite.model.User
import io.keyu.urekalite.model.UserLoginRequest
import io.keyu.urekalite.model.UserRepository

class UserViewModel : ViewModel() {

    private val userRepository: UserRepository = UserRepository()

    fun loginUser(user: UserLoginRequest): MutableLiveData<Resource<User>> {
        return userRepository.getUserLiveDataFromLogin(user)
    }

    fun getUserLiveData(): MutableLiveData<Resource<User>> {
        return userRepository.getUserLiveData()
    }

    fun clear() {
        userRepository.clear()
    }
}