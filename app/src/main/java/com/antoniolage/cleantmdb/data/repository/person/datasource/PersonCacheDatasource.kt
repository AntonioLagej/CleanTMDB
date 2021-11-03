package com.antoniolage.cleantmdb.data.repository.person.datasource

import com.antoniolage.cleantmdb.data.model.movies.Movie
import com.antoniolage.cleantmdb.data.model.people.Person

interface PersonCacheDatasource {
    suspend fun getPeopleFromCache():List<Person>
    suspend fun savePeopleToCache(people:List<Person>)

}