package com.pierresousa.likemovie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.repository.MovieRepository
import com.pierresousa.likemovie.webclient.MovieWebClient
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository by lazy {
        MovieRepository(MovieWebClient())
    }

    private val _movies = MutableLiveData<List<Movie>>().apply {
        viewModelScope.launch {
            value = repository.getPopular().results
        }
    }
    val movies: LiveData<List<Movie>> = _movies
}