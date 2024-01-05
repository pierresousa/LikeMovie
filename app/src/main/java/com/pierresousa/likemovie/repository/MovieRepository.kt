package com.pierresousa.likemovie.repository

import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.webclient.MovieWebClient
import com.pierresousa.likemovie.webclient.model.MovieResponse

class MovieRepository(
    private val webClient: MovieWebClient
) {
    suspend fun getPopular(): MovieResponse<Movie> {
        webClient.getPopular()?.let {
            return it
        } ?: return MovieResponse<Movie>()
    }
}