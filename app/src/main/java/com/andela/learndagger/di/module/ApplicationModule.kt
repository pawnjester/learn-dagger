package com.andela.learndagger.di.module

import android.app.Application
import com.andela.learndagger.BaseApp
import com.andela.learndagger.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application = baseApp
}