package com.antoniolage.cleantmdb.presentation.di.core

import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieCacheDatasource
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieLocalDatasource
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.movie.datasourceimpl.MovieRepositoryImpl
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonCacheDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonLocalDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasourceimpl.PersonRepositoryImpl
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowCacheDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowLocalDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasourceimpl.TVShowRepositoryImpl
import com.antoniolage.cleantmdb.domain.repository.MovieRepository
import com.antoniolage.cleantmdb.domain.repository.PersonRepository
import com.antoniolage.cleantmdb.domain.repository.TVshowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepositoty(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ):MovieRepository{
return MovieRepositoryImpl(
    movieRemoteDatasource,
    movieCacheDatasource,
    movieLocalDatasource)
    }
    @Singleton
    @Provides
    fun provideTVShowRepositoty(
        tvShowRemoteDatasource: TVShowRemoteDatasource,
        tvShowLocalDatasource: TVShowLocalDatasource,
        tvShowCacheDatasource: TVShowCacheDatasource
    ):TVshowRepository{
        return TVShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowCacheDatasource
            ,tvShowLocalDatasource

            )
    }
    @Singleton
    @Provides
    fun providePersonRepository(
        personRemoteDatasource: PersonRemoteDatasource,
        personLocalDatasource: PersonLocalDatasource,
        personCacheDatasource: PersonCacheDatasource
    ): PersonRepository {
        return PersonRepositoryImpl(
            personRemoteDatasource,
            personCacheDatasource,
            personLocalDatasource)
    }

}