package com.antoniolage.cleantmdb.data.repository.person.datasourceimpl

import android.util.Log
import com.antoniolage.cleantmdb.data.model.people.Person
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonCacheDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonLocalDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonRemoteDatasource
import com.antoniolage.cleantmdb.domain.repository.PersonRepository
import java.lang.Exception

class PersonRepositoryImpl(
    private val personRemoteDatasource: PersonRemoteDatasource,
    private val personCacheDatasource: PersonCacheDatasource,
    private val personLocalDatasource: PersonLocalDatasource
): PersonRepository {
    override suspend fun getPeople(): List<Person>? {
    return getPeopleFromCache()
    }

    override suspend fun updatePeople(): List<Person>? {

    val newListofPeople=getPeopleFromAPI()
        personLocalDatasource.clearAll()
        personLocalDatasource.savePeopleToDB(newListofPeople)
    personCacheDatasource.savePeopleToCache(newListofPeople)
    return newListofPeople
    }

    suspend fun getPeopleFromAPI():List<Person>{
        lateinit var personList: List<Person>
    try {
        val response=personRemoteDatasource.getPeople()
        val body= response.body()
        if(body!=null){
            personList=body.people
        }

    }catch (e:Exception){
        Log.i("Mytag",e.message.toString())
    }

        return personList
    }
    suspend fun getPeopleFromDB():List<Person>{
        lateinit var peopleList: List<Person>
        try {
        peopleList= personLocalDatasource.getPeopleFromDB()


        }catch (e:Exception){
            Log.i("Mytag",e.message.toString())
        }
        if(peopleList.size>0){
            return peopleList
        }else
        {
            peopleList=getPeopleFromAPI()
            personLocalDatasource.savePeopleToDB(peopleList)
        }

        return peopleList
    }
    suspend fun getPeopleFromCache():List<Person>{
        lateinit var peopleList: List<Person>
        try {
            peopleList= personCacheDatasource.getPeopleFromCache()


        }catch (e:Exception){
            Log.i("Mytag",e.message.toString())
        }
        if(peopleList.size>0){
            return peopleList
        }else
        {
                peopleList=getPeopleFromDB()
                personCacheDatasource.savePeopleToCache(peopleList)
        }

        return peopleList
    }
}