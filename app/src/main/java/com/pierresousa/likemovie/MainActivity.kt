package com.pierresousa.likemovie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pierresousa.likemovie.database.AppDatabase
import com.pierresousa.likemovie.databinding.ActivityMainBinding
import com.pierresousa.likemovie.model.Movie
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    private val db by lazy {
//        AppDatabase.getInstance(this).movieDao()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        lifecycleScope.launch {
//            Log.i("teste", "teste db: $db")
//            val saved = db.save(Movie(id = 848326,
//                title = "The Family Plan",
//                overview = "teste",
//                voteAverage = 5.5,
//                voteCount = 10,
//                posterPath = "/3CezGI4ORSgVKk5Ch3UUWtL7SET.jpg"))
//        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}