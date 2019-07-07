package com.example.ktapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ktapp.R
import com.example.ktapp.model.Post

class PostsAdapter(private val postList: MutableList<Post> = ArrayList()) : RecyclerView.Adapter<PostsAdapter.PostHolder>() {

    fun addItems(pList: List<Post>) {
        postList.clear()
        postList.addAll(pList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PostHolder {
        val postHolder = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return PostHolder(postHolder)
    }

    override fun getItemCount(): Int {
        // it's like, return postList != null ? postList.size() : 0; in Java
        // ?: = Elvis operator in Kotlin
        // !! = not null assertion operator in Kotlin
        // reference = https://kotlinlang.org/docs/reference/null-safety.html
        return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post: Post = postList.get(holder.adapterPosition)
        with(post) {
            // "with" keyword avoids redundant usage of class object inside the blocke43
            holder.tvTitle.text = title
            holder.tvBody.text = body
        }
    }

    inner class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvBody: TextView = itemView.findViewById(R.id.tv_body)
    }
}