package com.antoniolage.cleantmdb.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.antoniolage.cleantmdb.data.db.MovieDAO
import com.antoniolage.cleantmdb.data.db.PersonDAO
import com.antoniolage.cleantmdb.data.db.TVShowDAO
import com.antoniolage.cleantmdb.data.model.movies.Movie
import com.antoniolage.cleantmdb.data.model.people.Person
import com.antoniolage.cleantmdb.data.model.tvshows.TVShow

@Database(entities = [Movie::class,TVShow::class,Person::class],version = 1,exportSchema = false)
abstract class TMDBDatabase:RoomDatabase() {
abstract fun  movieDao(): MovieDAO
abstract fun  personDao(): PersonDAO
abstract fun tvDao(): TVShowDAO


}