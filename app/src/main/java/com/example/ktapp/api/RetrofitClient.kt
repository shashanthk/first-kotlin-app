package com.example.ktapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object {

        var retrofit: Retrofit? = null

        fun getApiInterface(): ApiInterface {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(ApiConstants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(buildHttpClient())
                        .build()
            }

            return retrofit!!.create(ApiInterface::class.java)
        }

        fun buildHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                    .connectTimeout(ApiConstants.TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(ApiConstants.TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(ApiConstants.TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(getHttpInterceptor())
                    .build()
        }

        fun getHttpInterceptor(): HttpLoggingInterceptor {
            val httpInterceptor = HttpLoggingInterceptor()
            httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpInterceptor
        }
    }
}
