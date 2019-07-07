package com.example.ktapp.api

import com.example.ktapp.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getPostsList(): Call<List<Post>>

}