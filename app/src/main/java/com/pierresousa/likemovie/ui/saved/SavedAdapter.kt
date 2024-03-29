package com.pierresousa.likemovie.ui.saved

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pierresousa.likemovie.R
import com.pierresousa.likemovie.databinding.MovieItemBinding
import com.pierresousa.likemovie.extensions.loadImagefromPath
import com.pierresousa.likemovie.model.Movie

class SavedAdapter(
    movies: List<Movie> = emptyList<Movie>(),
    var callBackDelete: (movie: Movie) -> Unit = {}
) : RecyclerView.Adapter<SavedAdapter.ViewHolder>() {

    private val movies = movies.toMutableList()

    inner class ViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var movie: Movie

        init {
            binding.movieItemSave.setOnClickListener {
                if (::movie.isInitialized) {
                    callBackDelete(movie)
                }
            }
        }

        fun assignsProperties(movie: Movie) {
            this.movie = movie

            val title = binding.movieItemTitle
            title.text = movie.title
            val overview = binding.movieItemOverview
            overview.text = movie.overview
            val voteAverage = binding.movieItemVote
            voteAverage.text = "${movie.voteAverage} (${movie.voteCount})"
            val poster = binding.movieItemPoster

            val imageViewVisibility = if (movie.posterPath != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            poster.visibility = imageViewVisibility
            poster.loadImagefromPath(movie.posterPath)

            val saveIcon = binding.movieItemSave
            saveIcon.setImageResource(R.drawable.ic_bookmark_blue)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.assignsProperties(movie)
    }

    override fun getItemCount(): Int = movies.size

    fun update(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

}
