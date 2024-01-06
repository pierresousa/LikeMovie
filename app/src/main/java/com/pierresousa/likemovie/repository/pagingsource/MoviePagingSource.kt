package com.pierresousa.likemovie.repository.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.webclient.MovieWebClient

private const val TAG = "MoviePagingSource"

class MoviePagingSource(
    private val backend: MovieWebClient
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
//        return state.anchorPosition
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            val response = backend.getPopular(nextPageNumber)
            response.totalPages?.let {
                if (nextPageNumber + 1 > it) throw Exception("Page exceeds maximum")
            }

            response.results?.let {
                LoadResult.Page(
                    data = it,
                    prevKey = null, // Only paging forward.
                    nextKey = nextPageNumber + 1
                )
            } ?: throw Exception("No results")

        } catch (e: Exception) {
            // Handle errors in this block and return LoadResult.Error for
            // expected errors (such as a network failure).
            Log.e(TAG, "load: ", e)
            LoadResult.Error(e)
        }
    }

}