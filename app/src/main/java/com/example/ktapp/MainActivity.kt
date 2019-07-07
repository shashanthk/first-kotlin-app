package com.example.ktapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.ktapp.api.RetrofitClient
import com.example.ktapp.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val posts = RetrofitClient.getApiInterface().getPostsList()

        posts.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val postList = response.body()

                postList?.forEach { post ->
                    Log.i(TAG, post.title)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e(TAG, t.message)
            }
        })
    }
}
