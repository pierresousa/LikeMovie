package com.pierresousa.likemovie.extensions

import android.widget.ImageView
import coil.load
import com.pierresousa.likemovie.R
import com.pierresousa.likemovie.WEB_API_BASE_URL_IMAGE

fun ImageView.loadImagefromPath(
    path: String,
    fallback: Int = R.drawable.no_photo_available
) {
    load(WEB_API_BASE_URL_IMAGE + path) {
        fallback(fallback)
        error(R.drawable.image_error)
        placeholder(R.drawable.photo_placeholder)
    }
}