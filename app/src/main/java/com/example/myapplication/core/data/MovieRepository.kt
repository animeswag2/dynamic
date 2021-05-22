package com.example.myapplication.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.myapplication.core.data.source.local.LocalDataSource
import com.example.myapplication.core.data.source.remote.RemoteDataSource
import com.example.myapplication.core.data.source.remote.response.MovieResponse
import com.example.myapplication.core.domain.model.Movie
import com.example.myapplication.core.domain.repository.IMovieRepository
import com.example.myapplication.core.utils.AppExecutors
import com.example.myapplication.core.utils.DataMapper

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTourism(): LiveData<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Movie>> {
                return Transformations.map(localDataSource.getAllMovie()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
//                data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override fun createCall(): LiveData<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asLiveData()

    override fun getFavoriteTourism(): LiveData<List<Tourism>> {
        return Transformations.map(localDataSource.getFavoriteTourism()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }

    override fun getAllMovie(): LiveData<Resource<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteMovie(): LiveData<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun setFavoriteMovie(Movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
    }
}