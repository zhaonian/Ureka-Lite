package io.keyu.urekalite.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.keyu.urekalite.model.post.Post
import io.keyu.urekalite.model.PostListRepository
import io.keyu.urekalite.model.Resource

class PostListViewModel : ViewModel() {

    private var postListRepository: PostListRepository = PostListRepository()

    fun getPostList(): MutableLiveData<Resource<List<Post>>> {
        return postListRepository.getPostListLiveData()
    }

    fun clear() {
        postListRepository.clear()
    }
}