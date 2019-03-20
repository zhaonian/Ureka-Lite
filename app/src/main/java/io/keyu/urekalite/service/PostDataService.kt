package io.keyu.urekalite.service

import io.keyu.urekalite.UrekaLiteApplication
import io.keyu.urekalite.model.post.Post
import io.reactivex.Observable
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import okhttp3.OkHttpClient
import retrofit2.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Query
import java.io.IOException

interface PostDataService {

    @GET(".")
    fun getPosts(
        @Query(value = "offset") offset: Int = 10,
        @Query(value = "limit") limit: Int = 20,
        @Query(value = "subscribedOnly") subscribedOnly: Boolean = false
    ): Observable<List<Post>>

    companion object {

        // for Logging
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                val newRequest = chain.request().newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer ${SharedPreferenceService.getToken(UrekaLiteApplication.context)}"
                    )
                    .addHeader("Content-Type", "application/json")
                    .build()
                return chain.proceed(newRequest)
            }
        }).addInterceptor(interceptor).build()

        val retrofit: PostDataService = Retrofit.Builder()
            .baseUrl("${Contract.UREKA_AWS}/post/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(PostDataService::class.java)
    }
}
