package com.andela.learndagger

import android.app.Application
import com.andela.learndagger.di.component.ApplicationComponent
import com.andela.learndagger.di.module.ApplicationModule
import dagger.android.DaggerApplication

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        setup()
    }

    fun setup() {
//        component = DaggerApplicationComponent.builder()
//                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    companion object {
        lateinit var instance: BaseApp private set
    }

    fun getApplicationComponent() : ApplicationComponent = component

}