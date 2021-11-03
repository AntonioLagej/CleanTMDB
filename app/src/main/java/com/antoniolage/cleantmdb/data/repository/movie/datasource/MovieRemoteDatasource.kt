package com.antoniolage.cleantmdb.data.repository.movie.datasource

import com.antoniolage.cleantmdb.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies():Response<MovieList>

}