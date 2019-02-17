package io.keyu.urekalite.service

import io.keyu.urekalite.model.User
import io.keyu.urekalite.model.UserLoginRequest
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.PUT

interface UserDataService {

    @PUT("login")
    fun loginUser(@Body user: UserLoginRequest): Observable<Response<User>>

    companion object {

        // for Logging
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()

        val retrofit: UserDataService = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-224-200.us-east-2.compute.amazonaws.com:8080/api/users/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(UserDataService::class.java)
    }
}
