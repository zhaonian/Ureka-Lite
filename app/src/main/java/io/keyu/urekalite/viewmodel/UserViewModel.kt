package io.keyu.urekalite.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.keyu.urekalite.model.User
import io.keyu.urekalite.model.UserRepository

class UserViewModel : ViewModel() {

    private val userRepository: UserRepository = UserRepository()

    fun loginUser(email: String, password: String): MutableLiveData<User> {
        return userRepository.getUserLiveData(email, password)
    }

    fun clear() {
        userRepository.clear()
    }
}