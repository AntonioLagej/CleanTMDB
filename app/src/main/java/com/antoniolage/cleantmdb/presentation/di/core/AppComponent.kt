package com.antoniolage.cleantmdb.presentation.di.core

import com.antoniolage.cleantmdb.presentation.di.movie.MovieSubComponent
import com.antoniolage.cleantmdb.presentation.di.people.PersonSubComponent
import com.antoniolage.cleantmdb.presentation.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TVShowSubComponent.Factory
    fun PersonSubComponent():PersonSubComponent.Factory

}