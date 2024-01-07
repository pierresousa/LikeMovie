package com.pierresousa.likemovie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie (
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val voteAverage: Double,
    val voteCount: Int,
    val posterPath: String? = null
)
