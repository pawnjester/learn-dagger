package com.andela.learndagger.di.component

import com.andela.learndagger.BaseApp
import com.andela.learndagger.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)
}