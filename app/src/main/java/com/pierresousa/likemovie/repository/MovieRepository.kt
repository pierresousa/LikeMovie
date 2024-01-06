package com.pierresousa.likemovie.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.pierresousa.likemovie.WEB_API_QUANTITY_PER_PAGE
import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.repository.pagingsource.MoviePagingSource
import com.pierresousa.likemovie.webclient.MovieWebClient

class MovieRepository(
    private val webClient: MovieWebClient
) {
    fun getPopular(): LiveData<PagingData<Movie>> {
        val liveData = Pager(
            PagingConfig(pageSize = WEB_API_QUANTITY_PER_PAGE)
        ) {
            MoviePagingSource(webClient)
        }.liveData

        return liveData
    }

}

