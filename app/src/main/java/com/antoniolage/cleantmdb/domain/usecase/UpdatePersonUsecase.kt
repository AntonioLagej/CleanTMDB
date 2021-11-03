package com.antoniolage.cleantmdb.domain.usecase

import com.antoniolage.cleantmdb.data.model.people.Person
import com.antoniolage.cleantmdb.domain.repository.PersonRepository

class UpdatePersonUsecase(private val personRepository: PersonRepository) {
    suspend fun execute():List<Person>? = personRepository.updatePeople()

}