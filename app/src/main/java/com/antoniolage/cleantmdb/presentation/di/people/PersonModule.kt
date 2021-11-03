package com.antoniolage.cleantmdb.presentation.di.people

import com.antoniolage.cleantmdb.domain.usecase.GetPersonUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdatePersonUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateTvShowUsecase
import com.antoniolage.cleantmdb.presentation.people.PeopleViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PersonModule {

    @PersonScope
    @Provides
    fun providesPersonViewModelFactory(
        getPersonUsecase: GetPersonUsecase,
        updatePersonUsecase: UpdatePersonUsecase
    ):PeopleViewModelFactory{

        return PeopleViewModelFactory(getPersonUsecase,updatePersonUsecase)
    }
}