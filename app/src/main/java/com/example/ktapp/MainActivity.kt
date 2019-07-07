package com.example.ktapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.ktapp.adapter.PostsAdapter
import com.example.ktapp.api.ApiInteractor
import com.example.ktapp.api.DataResponseListener
import com.example.ktapp.model.Post

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    lateinit var rvPosts: RecyclerView

    val postList = mutableListOf<Post>()
    var postsAdapter: PostsAdapter = PostsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPosts = findViewById(R.id.rv_posts_list)
        rvPosts.adapter = postsAdapter

        ApiInteractor.listAllPosts(object : DataResponseListener<List<Post>> {
            override fun onSuccess(data: List<Post>) {
                postList.clear()
                postList.addAll(data)
                postsAdapter.addItems(postList)
            }

            override fun onError(t: Throwable) {
                Log.e(TAG, t.message)
            }
        })
    }
}
