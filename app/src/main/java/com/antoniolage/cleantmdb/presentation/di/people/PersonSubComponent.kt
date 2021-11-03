package com.antoniolage.cleantmdb.presentation.di.people

import com.antoniolage.cleantmdb.presentation.people.PeopleActivity
import dagger.Subcomponent
@PersonScope
@Subcomponent(modules = [PersonModule::class])
interface PersonSubComponent {
fun inject(peopleActivity: PeopleActivity)
@Subcomponent.Factory
interface Factory{
    fun create():PersonSubComponent
}
}