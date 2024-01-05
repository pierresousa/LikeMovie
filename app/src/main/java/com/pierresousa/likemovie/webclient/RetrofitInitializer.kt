package com.pierresousa.likemovie.webclient

import com.pierresousa.likemovie.WEB_API_BASE_URL
import com.pierresousa.likemovie.webclient.services.MovieService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInitializer {
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(WEB_API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val movieService = retrofit.create(
        MovieService::class.java
    )
}