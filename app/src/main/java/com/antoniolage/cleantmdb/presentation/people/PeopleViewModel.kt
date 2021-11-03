package com.antoniolage.cleantmdb.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.antoniolage.cleantmdb.domain.usecase.GetPersonUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdatePersonUsecase

class PeopleViewModel(
 private val getPersonUsecase: GetPersonUsecase,
 private val updatePersonUsecase: UpdatePersonUsecase
):ViewModel() {
fun getPeople() = liveData {
    val peopleList = getPersonUsecase.execute()
    emit(peopleList)
}
fun updatePeople() = liveData {
    val peopleList = updatePersonUsecase.execute()
    emit(peopleList)
}
}