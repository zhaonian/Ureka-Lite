package io.keyu.urekalite.di.post

import dagger.Module
import dagger.Provides
import io.keyu.urekalite.service.PostDataService
import retrofit2.Retrofit

@Module
class PostModule {

    @Provides
    fun providePostService(retrofit: Retrofit): PostDataService {
        return retrofit.create(PostDataService::class.java)
    }
}
