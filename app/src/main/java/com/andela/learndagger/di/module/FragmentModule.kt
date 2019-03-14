package com.andela.learndagger.di.module

import com.andela.learndagger.api.ApiFactory
import com.andela.learndagger.api.ApiService
import dagger.Module
import dagger.Provides


@Module
class FragmentModule {

    @Provides
    fun provideApiService(): ApiService = ApiFactory.create()
 }