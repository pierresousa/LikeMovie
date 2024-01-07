package com.pierresousa.likemovie.webclient.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MovieResponse<T>(
    @Json(name = "page")
    val page: Int? = null,
    @Json(name = "results")
    val results: List<T>? = emptyList<T>(),
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "total_results")
    val totalResults: Int? = null
)