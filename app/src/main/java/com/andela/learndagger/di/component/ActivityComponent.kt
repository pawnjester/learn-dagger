package com.andela.learndagger.di.component

import com.andela.learndagger.MainActivity
import com.andela.learndagger.di.module.ActivityModule
import dagger.Component


@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}