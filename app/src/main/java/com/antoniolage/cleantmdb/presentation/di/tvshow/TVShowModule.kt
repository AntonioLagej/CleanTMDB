package com.antoniolage.cleantmdb.presentation.di.tvshow

import com.antoniolage.cleantmdb.domain.usecase.GetPersonUsecase
import com.antoniolage.cleantmdb.domain.usecase.GetTVshowUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdatePersonUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateTvShowUsecase
import com.antoniolage.cleantmdb.presentation.people.PeopleViewModelFactory
import com.antoniolage.cleantmdb.presentation.tvshows.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {

    @TVShowScope
    @Provides
    fun providesTVshowViewModelFactory(
        getTVshowUsecase: GetTVshowUsecase,
        updateTVshowUsecase: UpdateTvShowUsecase
    ): TVShowViewModelFactory {

        return TVShowViewModelFactory(getTVshowUsecase,updateTVshowUsecase)
    }
}