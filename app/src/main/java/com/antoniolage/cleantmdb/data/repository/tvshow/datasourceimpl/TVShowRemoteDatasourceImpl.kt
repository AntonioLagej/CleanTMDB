package com.antoniolage.cleantmdb.data.repository.tvshow.datasourceimpl

import com.antoniolage.cleantmdb.data.api.TMDBService
import com.antoniolage.cleantmdb.data.model.movies.MovieList
import com.antoniolage.cleantmdb.data.model.people.PeopleList
import com.antoniolage.cleantmdb.data.model.tvshows.TVShow
import com.antoniolage.cleantmdb.data.model.tvshows.TVShowList
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowRemoteDatasource
import retrofit2.Response

class TVShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ): TVShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TVShowList> = tmdbService.getPopularTvShow(apiKey)
}