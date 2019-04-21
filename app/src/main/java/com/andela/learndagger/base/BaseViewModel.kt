package com.andela.learndagger.base

import android.arch.lifecycle.ViewModel
import com.andela.learndagger.di.component.DaggerViewModelInjector
import com.andela.learndagger.di.component.ViewModelInjector
import com.andela.learndagger.di.module.NetworkModule
import com.andela.learndagger.ui.posts.PostListviewModel
import com.andela.learndagger.ui.posts.PostViewModel

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when(this) {
            is PostListviewModel -> injector.inject(this)
        }
    }

}