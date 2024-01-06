package com.pierresousa.likemovie.webclient.model

import com.pierresousa.likemovie.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MovieItemResponse(
    @Json(name = "adult")
    val adult: Boolean? = null,
    @Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @Json(name = "genre_ids")
    val genreIds: List<Int>? = emptyList<Int>(),
    @Json(name = "id")
    val id: Int,
    @Json(name = "original_language")
    val originalLanguage: String? = null,
    @Json(name = "original_title")
    val originalTitle: String? = null,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double? = null,
    @Json(name = "poster_path")
    val posterPath: String? = null,
    @Json(name = "release_date")
    val releaseDate: String? = null,
    @Json(name = "title")
    val title: String,
    @Json(name = "video")
    val video: Boolean? = null,
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