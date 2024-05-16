package com.example.trafficapp

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object ApiService {
    private const val BASE_URL = "https://api.jamesdecelis.com/api/v1/"

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface Service {
        @GET("streetname")
        fun allData(): Call<List<News>>
    }

    val service: Service by lazy {
        retrofit.create(Service::class.java)
    }
}
