package com.example.ktapp.model

import com.google.gson.annotations.SerializedName

class Post() {
    @SerializedName("userId")
    var userId: Int = 0
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("title")
    var title: String? = null
    @SerializedName("body")
    var body: String? = null
}