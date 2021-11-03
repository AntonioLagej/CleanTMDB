package com.antoniolage.cleantmdb.presentation.di

import com.antoniolage.cleantmdb.presentation.di.movie.MovieSubComponent
import com.antoniolage.cleantmdb.presentation.di.people.PersonSubComponent
import com.antoniolage.cleantmdb.presentation.di.tvshow.TVShowSubComponent


interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun tvShowSubComponent():TVShowSubComponent
    fun createPersonSubComponent():PersonSubComponent

}