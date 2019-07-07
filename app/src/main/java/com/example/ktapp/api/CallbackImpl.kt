package com.example.ktapp.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallbackImpl<T>(private val callback: DataResponseListener<T>) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful)
            callback.onSuccess(response.body()!!)
        else
            callback.onError(Throwable("Couldn't get response!!!"))
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        callback.onError(t)
    }

}