package com.antoniolage.cleantmdb.data.repository.movie.datasourceimpl

import com.antoniolage.cleantmdb.data.db.MovieDAO
import com.antoniolage.cleantmdb.data.model.movies.Movie
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDAO: MovieDAO) : MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
      return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
   CoroutineScope(Dispatchers.IO).launch {

       movieDAO.saveMovies(movies)
   }
    }

    override suspend fun clearAll() {
      CoroutineScope(Dispatchers.IO).launch {
          movieDAO.deleteAllMovies()
      }
    }
}