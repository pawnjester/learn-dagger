package com.andela.learndagger.ui.posts

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.andela.learndagger.R
import com.andela.learndagger.api.ApiService
import com.andela.learndagger.base.BaseViewModel
import com.andela.learndagger.models.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListviewModel : BaseViewModel() {

    @Inject
    lateinit var postApi: ApiService

    val postListAdapter = PostListAdapter();

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    private lateinit var subscription: Disposable



    init {
        loadPosts()
    }

    private fun loadPosts() {
        subscription = postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    onRetrievePostListStart()
                }.doOnTerminate {
                    onRetrievePostListFinish()
                }.subscribe({
                    onRetrievePostListSuccess(it)
                }, {
                    onRetrievePostListError()
                })
    }


    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(posts: List<Post>){
        postListAdapter.updateList(posts)
    }

    private fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}