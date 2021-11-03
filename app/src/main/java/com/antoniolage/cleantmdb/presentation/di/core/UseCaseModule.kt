package com.antoniolage.cleantmdb.presentation.di.core

import com.antoniolage.cleantmdb.domain.repository.MovieRepository
import com.antoniolage.cleantmdb.domain.repository.PersonRepository
import com.antoniolage.cleantmdb.domain.repository.TVshowRepository
import com.antoniolage.cleantmdb.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMovieUsecase{
    return GetMovieUsecase(movieRepository)
}
    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUsecase{
        return UpdateMoviesUsecase(movieRepository)
    }
    @Singleton
    @Provides
    fun provideGetTVShowUseCase(tvShowRepository: TVshowRepository):GetTVshowUsecase{
        return GetTVshowUsecase(tvShowRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateTVShowUseCase(tVshowRepository: TVshowRepository):UpdateTvShowUsecase{
        return UpdateTvShowUsecase(tVshowRepository)
    }
    @Singleton
    @Provides
    fun provideGetPersonUseCase(personRepository: PersonRepository):GetPersonUsecase{
        return GetPersonUsecase(personRepository)
    }
    @Singleton
    @Provides
    fun provideUpdatePersonUseCase(personRepository: PersonRepository):UpdatePersonUsecase{
        return UpdatePersonUsecase(personRepository)
    }
}