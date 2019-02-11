package io.keyu.urekalite.service

class RetrofitInstance {

//    companion object {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://jsonplaceholder.typicode.com/")
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//            .create(PostDataService::class.java)
//    }

//    private var retrofit: Retrofit? = null
//    private val baseUrl: String = "https://jsonplaceholder.typicode.com/"
//
//    fun getPostDataService(): PostDataService {
//        val okHttpClient = OkHttpClient().newBuilder()
//            .connectTimeout(120, TimeUnit.SECONDS)
//            .readTimeout(120, TimeUnit.SECONDS)
//            .writeTimeout(120, TimeUnit.SECONDS)
//            .build()
//
//        if (retrofit == null) {
//            retrofit = Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .client(okHttpClient)
//                .addConverterFactory(MoshiConverterFactory.create())
//                .build()
//        }
//        return retrofit!!.create(PostDataService::class.java)
//    }
}