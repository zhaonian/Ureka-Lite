package io.keyu.urekalite.di

import dagger.Module
import dagger.Provides
import io.keyu.urekalite.service.Contract
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Contract.UREKA_AWS)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
    }
}