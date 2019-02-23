package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.keyu.urekalite.R
import io.keyu.urekalite.model.SearchUser
import io.keyu.urekalite.viewmodel.UserSearchListViewModel

class SearchFragment : Fragment() {

    private lateinit var userSearchList: UserHorizontalScrollView
    private lateinit var userSearchListViewModel: UserSearchListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.view_search, container, false)
        userSearchList = rootView.findViewById(R.id.userSearchList)
        userSearchListViewModel = ViewModelProviders.of(activity!!).get(UserSearchListViewModel::class.java)
        getUserSearchList()
        return rootView
    }

    private fun getUserSearchList() {
        userSearchListViewModel.getUserSearchListLiveData().observe(this, Observer<List<SearchUser>> { resource ->
            userSearchList.setUserSearchList(resource)
        })
    }
}