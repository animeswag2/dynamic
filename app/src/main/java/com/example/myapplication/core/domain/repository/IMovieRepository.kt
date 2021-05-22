package com.example.myapplication.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.core.data.Resource
import com.example.myapplication.core.domain.model.Movie

interface IMovieRepository {

    fun getAllMovie(): LiveData<Resource<List<Movie>>>

    fun getFavoriteMovie(): LiveData<List<Movie>>

    fun setFavoriteMovie(Movie: Movie, state: Boolean)
}