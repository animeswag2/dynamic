package com.example.myapplication.core.di

import android.content.Context
import com.example.myapplication.core.data.MovieRepository
import com.example.myapplication.core.data.source.local.LocalDataSource
import com.example.myapplication.core.data.source.local.room.MovieDatabase
import com.example.myapplication.core.data.source.remote.RemoteDataSource
import com.example.myapplication.core.data.source.remote.network.ApiConfig
import com.example.myapplication.core.domain.repository.IMovieRepository
import com.example.myapplication.core.domain.usecase.MovieInteractor
import com.example.myapplication.core.domain.usecase.MovieUseCase
import com.example.myapplication.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): IMovieRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): MovieUseCase {
        val repository = provideRepository(context)
        return MovieInteractor(repository)
    }
}