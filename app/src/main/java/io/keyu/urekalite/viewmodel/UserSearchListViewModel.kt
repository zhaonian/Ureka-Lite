package io.keyu.urekalite.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.keyu.urekalite.model.SearchUser
import io.keyu.urekalite.model.UserSearchListRepository

class UserSearchListViewModel : ViewModel() {

    private var userSearchListRepository: UserSearchListRepository = UserSearchListRepository()

    fun getUserSearchListLiveData(): MutableLiveData<List<SearchUser>> {
        return userSearchListRepository.getUserSearchListLiveData()
    }

    fun clear() {
        userSearchListRepository.clear()
    }
}