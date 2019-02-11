package io.keyu.urekalite.service

import io.keyu.urekalite.model.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface PostDataService {

    @GET("photos")
    fun getPosts(): Call<List<Post>>

    companion object {
        val retrofit: PostDataService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(PostDataService::class.java)
    }
}
