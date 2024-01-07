package com.pierresousa.likemovie.ui.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pierresousa.likemovie.repository.MovieRepository

class SavedViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SavedViewModel::class.java)) return SavedViewModel(
            repository
        ) as T
        throw IllegalArgumentException("Model unknown")
    }
}