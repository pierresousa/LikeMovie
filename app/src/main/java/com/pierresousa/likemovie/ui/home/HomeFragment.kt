package com.pierresousa.likemovie.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.pierresousa.likemovie.MainApplication
import com.pierresousa.likemovie.databinding.FragmentHomeBinding
import com.pierresousa.likemovie.model.Movie
import com.pierresousa.likemovie.repository.MovieRepository
import com.pierresousa.likemovie.webclient.MovieWebClient
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = HomeAdapter()

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(
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
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

//        val saved = homeViewModel.save(
//            Movie(id = 695721,
//            title = "The Family Plan",
//            overview = "teste",
//            voteAverage = 5.5,
//            voteCount = 10,
//            posterPath = "/3CezGI4ORSgVKk5Ch3UUWtL7SET.jpg")
//        )

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setRecyclerView()

        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.getMovies().observe(viewLifecycleOwner) {
                adapter.submitData(lifecycle, it)
            }
        }

        return root
    }

    private fun setRecyclerView() {
        val recyclerView = binding.fragmentHomeMoviesRecyclerview
        recyclerView.adapter = adapter
        adapter.callBackSave = { movie ->
            homeViewModel.save(movie)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}