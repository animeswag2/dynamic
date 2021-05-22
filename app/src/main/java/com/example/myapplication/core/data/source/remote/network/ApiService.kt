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

    @GET("movie/popular?api_key=$API_KEY")
    fun getMovies(
        @Query("page") page: Int
    ): Call<MovieResponse>

    @GET("movie/{id}?api_key=$API_KEY")
    fun getMovieDetail(
        @Path("id") id: Int
    ): Call<ListMovieResponse>
}