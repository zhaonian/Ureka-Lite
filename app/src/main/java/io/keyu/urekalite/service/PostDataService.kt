package io.keyu.urekalite.service

import io.keyu.urekalite.model.Post
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface PostDataService {

    @GET("photos")
    fun getPosts(): Observable<List<Post>>

    companion object {
        val retrofit: PostDataService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(PostDataService::class.java)
    }
}
