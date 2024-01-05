package com.pierresousa.likemovie.webclient

import android.util.Log
import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.webclient.model.MovieResponse
import com.pierresousa.likemovie.webclient.services.MovieService

private const val TAG = "MovieWebClient"

class MovieWebClient {
    private val movieService: MovieService = RetrofitInitializer().movieService

    suspend fun getPopular(): MovieResponse<Movie>? {
        return try {
            val moviesResponse = movieService.getPopular()
            MovieResponse<Movie>(
                page = moviesResponse?.page,
                totalPages = moviesResponse?.totalPages,
                totalResults = moviesResponse?.totalResults,
                results = moviesResponse.results?.map { movieResponse ->
                    movieResponse.movie
                } ?: emptyList()
            )
        } catch (e: Exception) {
            Log.e(TAG, "getPopular: ", e)
            null
        }
    }
}