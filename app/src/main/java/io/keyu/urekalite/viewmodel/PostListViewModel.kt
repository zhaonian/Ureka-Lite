package io.keyu.urekalite.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.keyu.urekalite.model.Post
import io.keyu.urekalite.model.PostListRepository

class PostListViewModel : ViewModel() {

    private var postListRepository: PostListRepository = PostListRepository()

    fun getPostList(): MutableLiveData<List<Post>> {
        return postListRepository.getPostListLiveData()
    }

    fun clear() {
        postListRepository.clear()
    }
}