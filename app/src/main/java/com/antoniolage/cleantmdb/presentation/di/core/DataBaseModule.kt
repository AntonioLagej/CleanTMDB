package com.antoniolage.cleantmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.antoniolage.cleantmdb.data.db.MovieDAO
import com.antoniolage.cleantmdb.data.db.PersonDAO
import com.antoniolage.cleantmdb.data.db.TVShowDAO
import com.antoniolage.cleantmdb.data.model.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun providePersonDAO(tmdbDatabase: TMDBDatabase): PersonDAO {
        return tmdbDatabase.personDao()
    }

 @Singleton
    @Provides
    fun provideTVShowDAO(tmdbDatabase: TMDBDatabase):TVShowDAO{
        return tmdbDatabase.tvDao()
    }
}