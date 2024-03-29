package com.pierresousa.likemovie.ui.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.repository.MovieRepository
import kotlinx.coroutines.launch

class SavedViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()

    fun getMovies(): LiveData<List<Movie>> {
        val response = repository.getSaves()
        _movies.value = response.value
        return response
    }

    fun delete(movie: Movie) = viewModelScope.launch {
        repository.delete(movie)
        getMovies()
    }
}