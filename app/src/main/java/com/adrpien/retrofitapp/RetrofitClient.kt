package com.adrpien.retrofitapp

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // Creating OkHttpClient object
    private val client = OkHttpClient.Builder().build()

    // Creating Retrofit Instance
    val instance by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://picsum.photos")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()

        retrofit.create(PicsumService::class.java)
    }
}