package com.example.myapplication.detail

import androidx.lifecycle.ViewModel
import com.example.myapplication.core.domain.model.Movie
import com.example.myapplication.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) = movieUseCase.setFavoriteMovie(movie, newStatus)
}