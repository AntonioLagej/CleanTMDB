package com.antoniolage.cleantmdb.presentation.di.core

import com.antoniolage.cleantmdb.data.db.MovieDAO
import com.antoniolage.cleantmdb.data.db.PersonDAO
import com.antoniolage.cleantmdb.data.db.TVShowDAO
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieLocalDatasource
import com.antoniolage.cleantmdb.data.repository.movie.datasourceimpl.MovieLocalDatasourceImpl
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonLocalDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasourceimpl.PersonLocalDatasourceImpl
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowLocalDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasourceimpl.TVShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule (){

    @Singleton
    @Provides
fun providesMovieLocalDataSource(movieDAO: MovieDAO):MovieLocalDatasource{
    return MovieLocalDatasourceImpl(movieDAO)
}
    @Singleton
    @Provides
    fun providesTVShowLocalDataSource(tvShowDAO: TVShowDAO):TVShowLocalDatasource{

        return TVShowLocalDatasourceImpl(tvShowDAO)
    }

    @Singleton
    @Provides
    fun providesPersonLocalDataSource(PersonDAO: PersonDAO):PersonLocalDatasource{

        return PersonLocalDatasourceImpl(PersonDAO)
    }

}