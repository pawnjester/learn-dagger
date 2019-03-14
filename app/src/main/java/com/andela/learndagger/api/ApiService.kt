package com.andela.learndagger.api

import com.andela.learndagger.models.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    companion object {
        val BASE_URL = "https://api.nytimes.com/svc/topstories/v2/"
    }

    @GET("food.json")
    fun getFood(): Observable<List<Post>>
}