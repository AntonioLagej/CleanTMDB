package com.antoniolage.cleantmdb.presentation.di.tvshow

import com.antoniolage.cleantmdb.presentation.tvshows.TVShowActivity
import dagger.Subcomponent
@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {
fun inject(tvShowActivity: TVShowActivity)
@Subcomponent.Factory
interface Factory{
    fun create():TVShowSubComponent
}
}