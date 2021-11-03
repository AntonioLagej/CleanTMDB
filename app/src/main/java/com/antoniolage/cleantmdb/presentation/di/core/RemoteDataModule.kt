package com.antoniolage.cleantmdb.presentation.di.core

import android.util.Log
import com.antoniolage.cleantmdb.data.api.TMDBService
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.movie.datasourceimpl.MovieRemoteDatasourceImpl
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasourceimpl.PersonRemoteDatasourceImpl
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowRemoteDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasourceimpl.TVShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(
    private val apiKey:String
) {
    @Singleton
    @Provides
fun providesMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDatasource{
        Log.i("mytag","insideRemotedataModule ${apiKey}")
    return MovieRemoteDatasourceImpl(tmdbService, apiKey)
}
    @Singleton
    @Provides
    fun providesPersonRemoteDataSource(tmdbService: TMDBService):PersonRemoteDatasource{
        return PersonRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providesTVShowRemoteDataSource(tmdbService: TMDBService):TVShowRemoteDatasource{
        return TVShowRemoteDatasourceImpl(tmdbService, apiKey)
    }

}