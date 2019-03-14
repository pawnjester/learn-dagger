package com.andela.learndagger.di.module

import android.app.Activity
import com.andela.learndagger.ui.main.MainContract
import com.andela.learndagger.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity() : Activity = activity

    @Provides
    fun providePresenter(): MainContract.Presenter = MainPresenter()
}