package io.keyu.urekalite.model

import androidx.lifecycle.MutableLiveData

class UserSearchListRepository {

    private val userListLiveData: MutableLiveData<List<SearchUser>> = MutableLiveData()

    fun getUserSearchListLiveData(): MutableLiveData<List<SearchUser>> {
        userListLiveData.postValue(
            listOf(
                SearchUser(1, "https://gravatar.com/avatar/260bbcf5c18fc5753e9ce32a4f91bf0f?s=400&d=monsterid&r=x"),
                SearchUser(2, "https://gravatar.com/avatar/260bbcf5c18fc5753e9ce32a4f91bf0f?s=400&d=mp&r=x"),
                SearchUser(3, "https://gravatar.com/avatar/260bbcf5c18fc5753e9ce32a4f91bf0f?s=400&d=identicon&r=x"),
                SearchUser(4, "https://gravatar.com/avatar/260bbcf5c18fc5753e9ce32a4f91bf0f?s=400&d=wavatar&r=x"),
                SearchUser(5, "https://gravatar.com/avatar/260bbcf5c18fc5753e9ce32a4f91bf0f?s=400&d=retro&r=x"),
                SearchUser(6, "https://gravatar.com/avatar/260bbcf5c18fc5753e9ce32a4f91bf0f?s=400&d=robohash&r=x"),
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