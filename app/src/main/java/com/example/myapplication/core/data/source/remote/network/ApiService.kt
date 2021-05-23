package com.example.myapplication.core.data.source.remote.network

import com.example.myapplication.core.data.source.remote.response.ListMovieResponse
import com.example.myapplication.core.data.source.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val API_KEY = ApiKey.TMDB_API_KEY
    }

    @GET("movie")
    suspend fun getMovie(
        @Query("api_key") apiKey: String,
    ): ListMovieResponse
}