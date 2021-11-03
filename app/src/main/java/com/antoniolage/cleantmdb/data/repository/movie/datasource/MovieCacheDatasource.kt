package com.antoniolage.cleantmdb.data.repository.movie.datasource

import com.antoniolage.cleantmdb.data.model.movies.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)

}