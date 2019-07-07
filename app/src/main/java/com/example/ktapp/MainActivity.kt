package com.example.ktapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.ktapp.adapter.PostsAdapter
import com.example.ktapp.api.RetrofitClient
import com.example.ktapp.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val posts = RetrofitClient.getApiInterface().getPostsList()

        posts.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                postList.clear()
                postList.addAll(response.body()!!)
                postsAdapter.addItems(postList)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e(TAG, t.message)
            }
        })
    }
}
