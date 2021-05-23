package com.example.myapplication.di

import com.example.myapplication.core.domain.usecase.MovieInteractor
import com.example.myapplication.core.domain.usecase.MovieUseCase
import com.example.myapplication.detail.DetailMovieViewModel
import com.example.myapplication.favorite.FavoriteViewModel
import com.example.myapplication.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}