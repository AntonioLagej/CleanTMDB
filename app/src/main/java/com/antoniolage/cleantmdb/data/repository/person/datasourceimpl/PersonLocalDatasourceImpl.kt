package com.antoniolage.cleantmdb.data.repository.person.datasourceimpl

import com.antoniolage.cleantmdb.data.db.PersonDAO

import com.antoniolage.cleantmdb.data.model.people.Person
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonLocalDatasourceImpl(private val personDAO: PersonDAO) : PersonLocalDatasource {
    override suspend fun getPeopleFromDB(): List<Person> {


      return personDAO.getPeople()
    }

    override suspend fun savePeopleToDB(people: List<Person>) {


   CoroutineScope(Dispatchers.IO).launch {
       personDAO.savePeople(people)
   }
    }

    override suspend fun clearAll() {
      CoroutineScope(Dispatchers.IO).launch {
        personDAO.deleteAllPeople()
      }
    }
}