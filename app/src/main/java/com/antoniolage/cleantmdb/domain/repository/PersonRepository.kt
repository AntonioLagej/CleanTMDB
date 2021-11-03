package com.antoniolage.cleantmdb.domain.repository

import com.antoniolage.cleantmdb.data.model.people.Person

interface PersonRepository {
    suspend fun getPeople():List<Person>?
    suspend fun updatePeople():List<Person>?
}