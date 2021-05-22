package com.example.myapplication.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MovieResponse(
    @field:SerializedName("id")
    val id: Int = 0,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("poster_path")
    val poster: String? = null,

    @field:SerializedName("release_date")
    val release: String? = null,
)