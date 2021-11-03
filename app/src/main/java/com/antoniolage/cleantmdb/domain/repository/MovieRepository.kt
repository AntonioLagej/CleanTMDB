package com.antoniolage.cleantmdb.domain.repository

import com.antoniolage.cleantmdb.data.model.movies.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}