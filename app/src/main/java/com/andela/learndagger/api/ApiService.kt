package com.andela.learndagger.api

import com.andela.learndagger.models.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}