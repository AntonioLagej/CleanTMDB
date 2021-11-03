package com.antoniolage.cleantmdb.presentation.di.core

import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieCacheDatasource
import com.antoniolage.cleantmdb.data.repository.movie.datasourceimpl.MovieCacheDatasouceImpl
import com.antoniolage.cleantmdb.data.repository.person.datasource.PersonCacheDatasource
import com.antoniolage.cleantmdb.data.repository.person.datasourceimpl.PersonCacheDatasouceImpl
import com.antoniolage.cleantmdb.data.repository.person.datasourceimpl.PersonLocalDatasourceImpl
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowCacheDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasourceimpl.TVShowCacheDatasouceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
fun provideMovieCacheDataSource():MovieCacheDatasource{
    return  MovieCacheDatasouceImpl()
}
    @Singleton
    @Provides
    fun providePersonCacheDataSource():PersonCacheDatasource{
        return  PersonCacheDatasouceImpl()
    }
    @Singleton
    @Provides
    fun provideTVShowCacheDataSource():TVShowCacheDatasource{
        return  TVShowCacheDatasouceImpl()
    }
}