package com.andela.learndagger.ui.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.andela.learndagger.base.BaseViewModel
import com.andela.learndagger.models.Post

class PostViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post){
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody():MutableLiveData<String>{
        return postBody
    }
}