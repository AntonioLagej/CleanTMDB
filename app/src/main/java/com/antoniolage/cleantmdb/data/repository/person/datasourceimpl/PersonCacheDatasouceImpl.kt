package com.antoniolage.cleantmdb.data.repository.person.datasourceimpl

import com.antoniolage.cleantmdb.data.model.people.Person
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonCacheDatasource

class PersonCacheDatasouceImpl: PersonCacheDatasource {
   private var peopleList= ArrayList<Person>()

    override suspend fun getPeopleFromCache(): List<Person> {
      return peopleList
    }

    override suspend fun savePeopleToCache(people: List<Person>) {
        peopleList.clear()
        peopleList= ArrayList(people)
    }
}