package com.pierresousa.likemovie.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pierresousa.likemovie.databinding.MovieItemBinding
import com.pierresousa.likemovie.extensions.loadImagefromPath
import com.pierresousa.likemovie.model.Movie

class HomeAdapter(var callBackSave: (movie: Movie) -> Unit = {}) :
    PagingDataAdapter<Movie, HomeAdapter.ViewHolder>(MovieComparator) {
    inner class ViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var movie: Movie

        init {
            binding.movieItemSave.setOnClickListener {
                if (::movie.isInitialized) {
                    callBackSave(movie)
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
        }
    }

    object MovieComparator : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.assignsProperties(it)
        }
    }
}