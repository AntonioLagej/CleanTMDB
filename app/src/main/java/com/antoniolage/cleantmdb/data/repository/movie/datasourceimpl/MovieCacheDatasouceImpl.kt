package com.antoniolage.cleantmdb.data.repository.movie.datasourceimpl

import com.antoniolage.cleantmdb.data.model.movies.Movie
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasouceImpl: MovieCacheDatasource {
   private var movieList= ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
      return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
       movieList.clear()
        movieList= ArrayList(movies)
    }
}