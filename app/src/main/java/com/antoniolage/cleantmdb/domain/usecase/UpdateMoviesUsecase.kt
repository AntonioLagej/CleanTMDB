package com.antoniolage.cleantmdb.domain.usecase

import com.antoniolage.cleantmdb.data.model.movies.Movie
import com.antoniolage.cleantmdb.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()

}