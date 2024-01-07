package com.pierresousa.likemovie

import android.app.Application
import com.pierresousa.likemovie.database.AppDatabase

class MainApplication : Application() {

    val database by lazy {
        AppDatabase.getInstance(this@MainApplication)
    }
}