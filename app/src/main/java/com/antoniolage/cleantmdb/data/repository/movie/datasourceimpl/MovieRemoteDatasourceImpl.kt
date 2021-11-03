package com.antoniolage.cleantmdb.data.repository.movie.datasourceimpl

import com.antoniolage.cleantmdb.data.api.TMDBService
import com.antoniolage.cleantmdb.data.model.movies.MovieList
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}