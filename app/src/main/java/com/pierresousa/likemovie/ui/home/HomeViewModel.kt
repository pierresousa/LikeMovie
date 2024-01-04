package com.pierresousa.likemovie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pierresousa.likemovie.model.Movie

class HomeViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>().apply {
        value = listOf(
            Movie(
                id = 1,
                title = "Rebel Moon - Part One: A Child of Fire",
                overview = "When a peaceful colony on the edge of the galaxy finds itself threatened by the armies of the tyrannical Regent Balisarius, they dispatch Kora, a young woman with a mysterious past, to seek out warriors from neighboring planets to help them take a stand.",
                posterPath = "/ui4DrH1cKk2vkHshcUcGt2lKxCm.jpg",
                voteAverage = 6.5,
                voteCount = 922
            ), Movie(
                id = 2,
                title = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                posterPath = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                voteAverage = 6.5,
                voteCount = 1886
            )
        )
    }
    val movies: LiveData<List<Movie>> = _movies
}