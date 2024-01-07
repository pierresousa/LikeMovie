package com.pierresousa.likemovie.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pierresousa.likemovie.DB_NAME
import com.pierresousa.likemovie.database.dao.MovieDao
import com.pierresousa.likemovie.model.Movie

@Database(
    version = 1,
    entities = [
        Movie::class
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var db: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DB_NAME
            ).build()
        }
    }
}