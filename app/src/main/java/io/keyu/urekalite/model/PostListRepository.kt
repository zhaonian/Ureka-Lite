package io.keyu.urekalite.model

import androidx.lifecycle.MutableLiveData

class PostListRepository() {

    private var postListLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun getPostListLiveData(): MutableLiveData<List<Post>> {
//        var postData: Call<Post> = PostDataService.create().getPosts()
        return postListLiveData
    }
}
