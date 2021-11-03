package com.antoniolage.cleantmdb.presentation.di.movie

import com.antoniolage.cleantmdb.domain.usecase.GetMovieUsecase
import com.antoniolage.cleantmdb.domain.usecase.GetPersonUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdateMoviesUsecase
import com.antoniolage.cleantmdb.domain.usecase.UpdatePersonUsecase
import com.antoniolage.cleantmdb.presentation.movie.MovieViewModelFactory
import com.antoniolage.cleantmdb.presentation.people.PeopleViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMovieUsecase: GetMovieUsecase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {

        return MovieViewModelFactory(getMovieUsecase,updateMoviesUsecase)
    }
}