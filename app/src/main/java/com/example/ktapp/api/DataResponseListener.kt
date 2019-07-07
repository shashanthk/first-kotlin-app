package com.example.ktapp.api

interface DataResponseListener<T> {
    fun onSuccess(data: T)
    fun onError(t: Throwable)
}