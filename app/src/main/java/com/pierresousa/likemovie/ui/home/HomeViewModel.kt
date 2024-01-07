package com.pierresousa.likemovie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<PagingData<Movie>>()

    fun getMovies(): LiveData<PagingData<Movie>> {
        val response = repository.getPopular().cachedIn(viewModelScope)
        _movies.value = response.value
        return response
    }

    fun save(movie: Movie) = viewModelScope.launch {
        repository.save(movie)
    }
}