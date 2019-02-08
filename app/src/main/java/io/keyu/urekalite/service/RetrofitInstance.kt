package io.keyu.urekalite.service

import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {

    private var retrofit: Retrofit? = null
    private val baseUrl: String = "https://jsonplaceholder.typicode.com/"

    fun getPostDataService(): PostDataService {
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
        return retrofit!!.create(PostDataService::class.java)
    }
}