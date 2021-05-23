package com.example.myapplication.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.myapplication.core.data.Resource
import com.example.myapplication.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}