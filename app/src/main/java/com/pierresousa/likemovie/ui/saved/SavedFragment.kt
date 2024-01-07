package com.pierresousa.likemovie.ui.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.pierresousa.likemovie.MainApplication
import com.pierresousa.likemovie.databinding.FragmentSavedBinding
import com.pierresousa.likemovie.repository.MovieRepository
import com.pierresousa.likemovie.ui.home.HomeAdapter
import com.pierresousa.likemovie.ui.home.HomeViewModel
import com.pierresousa.likemovie.ui.home.HomeViewModelFactory
import com.pierresousa.likemovie.webclient.MovieWebClient

class SavedFragment : Fragment() {

    private var _binding: FragmentSavedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = SavedAdapter()

    private val savedViewModel: SavedViewModel by viewModels {
        SavedViewModelFactory(
            MovieRepository(
                MovieWebClient(),
                (requireActivity().application as MainApplication).database.movieDao()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val savedViewModel =
//            ViewModelProvider(this).get(SavedViewModel::class.java)

        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setRecyclerView()

        savedViewModel.getMovies().observe(viewLifecycleOwner) {
            adapter.update(it)
        }

        return root
    }

    private fun setRecyclerView() {
        val recyclerView = binding.fragmentSavedMoviesRecyclerview
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}