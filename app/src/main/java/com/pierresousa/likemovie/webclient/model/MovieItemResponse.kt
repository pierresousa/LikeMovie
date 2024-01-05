package com.pierresousa.likemovie.webclient.model

import com.pierresousa.likemovie.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MovieItemResponse(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String? = null,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
) {
    val movie: Movie
        get() = Movie(
            id = id,
            title = title,
            overview = overview,
            voteAverage = voteAverage,
            voteCount = voteCount,
            posterPath = posterPath
        )
}