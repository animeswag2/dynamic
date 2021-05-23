package com.example.myapplication.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myapplication.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}