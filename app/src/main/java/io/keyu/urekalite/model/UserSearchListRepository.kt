package io.keyu.urekalite.model

import androidx.lifecycle.MutableLiveData

class UserSearchListRepository {

    private val userListLiveData: MutableLiveData<List<SearchUser>> = MutableLiveData()

    fun getUserSearchListLiveData(): MutableLiveData<List<SearchUser>> {
        userListLiveData.postValue(
            listOf(
                SearchUser(1, ""),
                SearchUser(2, ""),
                SearchUser(3, ""),
                SearchUser(4, ""),
                SearchUser(5, ""),
                SearchUser(6, ""),
                SearchUser(7, ""),
                SearchUser(8, ""),
                SearchUser(9, ""),
                SearchUser(10, "")
            )
        )
        return userListLiveData
    }

    fun clear() {
    }
}