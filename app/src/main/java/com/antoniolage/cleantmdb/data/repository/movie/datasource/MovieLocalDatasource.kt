package com.antoniolage.cleantmdb.data.repository.movie.datasource

import com.antoniolage.cleantmdb.data.model.movies.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}