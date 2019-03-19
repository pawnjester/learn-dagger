package com.andela.learndagger.di.component

import com.andela.learndagger.di.module.NetworkModule
import com.andela.learndagger.ui.posts.PostListviewModel
import com.andela.learndagger.ui.posts.PostViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    /**
     * Injects the required dependencies into PostListViewModel
     */
    fun inject(postListviewModel: PostListviewModel)

    /**
     * Injects the required dependencies into PostViewModel
     */
    fun inject(postViewModel: PostViewModel)


    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}