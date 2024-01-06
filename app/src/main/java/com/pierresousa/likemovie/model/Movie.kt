package com.pierresousa.likemovie.model

data class Movie (
    val id: Int,
    val title: String,
    val overview: String,
    val voteAverage: Double,
    val voteCount: Int,
    val posterPath: String? = null
)
