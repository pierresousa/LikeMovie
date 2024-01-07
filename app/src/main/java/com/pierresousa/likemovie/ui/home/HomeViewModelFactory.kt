package com.pierresousa.likemovie.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pierresousa.likemovie.repository.MovieRepository

class HomeViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) return HomeViewModel(repository) as T
        throw IllegalArgumentException("Model unknown")
    }
}