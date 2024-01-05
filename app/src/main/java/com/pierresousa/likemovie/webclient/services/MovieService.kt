package com.pierresousa.likemovie.webclient.services

import com.pierresousa.likemovie.WEB_API_API_KEY
import com.pierresousa.likemovie.WEB_API_DEFAULT_LANGUAGE
import com.pierresousa.likemovie.WEB_API_DEFAULT_PAGE
import com.pierresousa.likemovie.webclient.model.MovieItemResponse
import com.pierresousa.likemovie.webclient.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopular(
        @Query("language") language: String = WEB_API_DEFAULT_LANGUAGE,
        @Query("page") page: Int = WEB_API_DEFAULT_PAGE,
        @Query("api_key") apiKey: String = WEB_API_API_KEY
    ): MovieResponse<MovieItemResponse>
}