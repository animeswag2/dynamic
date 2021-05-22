package com.example.myapplication.core.utils

import com.example.myapplication.core.data.source.local.entity.MovieEntity
import com.example.myapplication.core.data.source.remote.response.MovieResponse
import com.example.myapplication.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity>
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

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                title = it.title,
                overview = it.overview,
                poster = it.poster,
                release = it.release,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        title = input.title,
        overview = input.overview,
        poster = input.poster,
        release = input.release,
        isFavorite = input.isFavorite
    )
}