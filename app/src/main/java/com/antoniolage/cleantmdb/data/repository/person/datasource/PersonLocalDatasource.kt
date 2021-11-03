package com.antoniolage.cleantmdb.data.repository.person.datasource

import com.antoniolage.cleantmdb.data.model.people.Person

interface PersonLocalDatasource {
    suspend fun getPeopleFromDB(): List<Person>
    suspend fun savePeopleToDB(movies: List<Person>)
    suspend fun clearAll()
}