package com.example.myapplication.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.core.data.Resource
import com.example.myapplication.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(Movie: Movie, state: Boolean)
}