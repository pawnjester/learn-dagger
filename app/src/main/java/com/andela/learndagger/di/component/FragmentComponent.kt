package com.andela.learndagger.di.component

import com.andela.learndagger.di.module.FragmentModule
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
}