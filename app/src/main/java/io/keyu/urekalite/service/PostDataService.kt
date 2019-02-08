package io.keyu.urekalite.service

import io.keyu.urekalite.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostDataService {

    @GET("photos")
    fun getPosts(): Call<Post>
}
