package com.antoniolage.cleantmdb.data.repository.person.datasource

import com.antoniolage.cleantmdb.data.model.movies.MovieList
import com.antoniolage.cleantmdb.data.model.people.PeopleList
import retrofit2.Response

interface PersonRemoteDatasource {
    suspend fun getPeople():Response<PeopleList>

}