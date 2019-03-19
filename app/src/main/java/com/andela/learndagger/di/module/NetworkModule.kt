package com.andela.learndagger.di.module

import com.andela.learndagger.api.ApiFactory
import com.andela.learndagger.api.ApiService
import com.andela.learndagger.api.ApiService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {


    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(): ApiService = ApiFactory.create()

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}