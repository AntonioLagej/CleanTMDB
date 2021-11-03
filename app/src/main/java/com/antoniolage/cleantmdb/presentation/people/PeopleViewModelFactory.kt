package com.antoniolage.cleantmdb.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antoniolage.cleantmdb.domain.usecase.GetMovieUsecase
import com.antoniolage.cleantmdb.domain.usecase.GetPersonUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateMoviesUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdatePersonUsecase

class PeopleViewModelFactory(
    private val getPersonUsecase: GetPersonUsecase,
    private val updatePersonUsecase: UpdatePersonUsecase
    ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return PeopleViewModel(getPersonUsecase,updatePersonUsecase) as T
    }

}