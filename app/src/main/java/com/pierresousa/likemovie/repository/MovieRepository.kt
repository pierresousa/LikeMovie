package com.pierresousa.likemovie.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.pierresousa.likemovie.WEB_API_QUANTITY_PER_PAGE
import com.pierresousa.likemovie.database.dao.MovieDao
import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.repository.pagingsource.MoviePagingSource
import com.pierresousa.likemovie.webclient.MovieWebClient

class MovieRepository(
    private val webClient: MovieWebClient,
    private val dao: MovieDao
) {
    fun getPopular(): LiveData<PagingData<Movie>> {
        val liveData = Pager(
            PagingConfig(pageSize = WEB_API_QUANTITY_PER_PAGE)
        ) {
            MoviePagingSource(webClient)
        }.liveData

        return liveData
    }

    suspend fun save(movie: Movie) {
        dao.save(movie)
    }

    fun getSaves(): LiveData<List<Movie>> {
        return dao.getAll()
    }

    suspend fun delete(movie: Movie) {
        dao.delete(movie)
    }

    fun getById(id: Int): LiveData<Movie?> {
        return dao.getById(id)
    }
}

