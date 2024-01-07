package com.pierresousa.likemovie.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pierresousa.likemovie.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(movie: Movie)

    @Query("SELECT * FROM Movie")
    fun getAll(): LiveData<List<Movie>>
}