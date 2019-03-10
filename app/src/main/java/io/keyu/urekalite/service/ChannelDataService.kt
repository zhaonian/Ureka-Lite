package io.keyu.urekalite.service

import io.keyu.urekalite.UrekaLiteApplication
import io.keyu.urekalite.model.post.ChannelGroupGroup
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.io.IOException

interface ChannelDataService {

    @GET("groupTree")
    fun getBranchList(): Observable<List<ChannelGroupGroup>>

    companion object {

        // for Logging
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
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

        val retrofit: ChannelDataService = Retrofit.Builder()
            .baseUrl("${Contract.UREKA_AWS}/channel/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(ChannelDataService::class.java)
    }
}
