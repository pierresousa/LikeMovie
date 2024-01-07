package com.pierresousa.likemovie.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
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

    @Delete
    suspend fun delete(movie: Movie)

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun getById(id: Int): LiveData<Movie?>
}