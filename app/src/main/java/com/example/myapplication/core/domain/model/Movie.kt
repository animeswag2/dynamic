package com.example.myapplication.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieId: String,
    val title: String,
    val overview: String,
    val poster: String,
    val release: String,
    val isFavorite: Boolean
) : Parcelable
