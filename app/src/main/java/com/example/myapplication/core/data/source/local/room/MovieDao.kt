package com.example.myapplication.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieentities")
    fun getAllMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie: MovieEntity)
}