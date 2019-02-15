package io.keyu.urekalite.service

import io.keyu.urekalite.model.User
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserDataService {

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Observable<User>

    companion object {
        val retrofit: UserDataService = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-224-200.us-east-2.compute.amazonaws.com:8080/api/users/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(UserDataService::class.java)
    }
}
