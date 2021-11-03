package com.antoniolage.cleantmdb.presentation.di.core

import android.content.Context
import com.antoniolage.cleantmdb.presentation.di.movie.MovieSubComponent
import com.antoniolage.cleantmdb.presentation.di.people.PersonSubComponent
import com.antoniolage.cleantmdb.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    MovieSubComponent::class,
    TVShowSubComponent::class,
    PersonSubComponent::class
])
class AppModule(private val context: Context) {
@Singleton
@Provides
    fun provideAppContext():Context{
        return context.applicationContext
    }
}