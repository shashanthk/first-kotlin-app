package com.example.ktapp.api

import com.example.ktapp.model.Post

class ApiInteractor {

    companion object {
        fun listAllPosts(callback: DataResponseListener<List<Post>>) {
            val posts = RetrofitClient.getApiInterface().getPostsList()
            posts.enqueue(CallbackImpl(callback))
        }
    }
}