package com.antoniolage.cleantmdb.presentation.di.movie

import com.antoniolage.cleantmdb.presentation.movie.MovieActivity
import com.antoniolage.cleantmdb.presentation.people.PeopleActivity
import dagger.Subcomponent
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
fun inject(movieActivity: MovieActivity)
@Subcomponent.Factory
interface Factory{
    fun create():MovieSubComponent
}
}