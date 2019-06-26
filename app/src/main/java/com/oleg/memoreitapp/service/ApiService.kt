package com.oleg.memoreitapp.service

import com.oleg.memoreitapp.APIRequest.PhotoSessionService
import com.oleg.memoreitapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private val client = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val photoSessionService: PhotoSessionService = client.create(PhotoSessionService::class.java)
}