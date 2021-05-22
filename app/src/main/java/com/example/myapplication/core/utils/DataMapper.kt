package com.example.myapplication.core.utils

import com.example.myapplication.core.data.source.local.entity.MovieEntity
import com.example.myapplication.core.data.source.remote.response.MovieResponse

object DataMapper {
    fun mapResponseToEntities(input: List<MovieResponse>): List<MovieEntity>
    {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id,
                title = it.title,
                overview = it.overview,
                poster = it.poster,
                release = it.release,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }
}