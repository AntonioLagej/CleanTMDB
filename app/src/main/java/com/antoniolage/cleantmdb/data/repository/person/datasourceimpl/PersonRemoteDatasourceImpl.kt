package com.antoniolage.cleantmdb.data.repository.person.datasourceimpl

import com.antoniolage.cleantmdb.data.api.TMDBService
import com.antoniolage.cleantmdb.data.model.movies.MovieList
import com.antoniolage.cleantmdb.data.model.people.PeopleList
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonRemoteDatasource
import retrofit2.Response

class PersonRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ): PersonRemoteDatasource {
    override suspend fun getPeople(): Response<PeopleList> = tmdbService.getPopularPerson(apiKey)
}