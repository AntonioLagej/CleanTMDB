package com.antoniolage.cleantmdb.presentation

import android.app.Application
import com.antoniolage.cleantmdb.BuildConfig
import com.antoniolage.cleantmdb.presentation.di.Injector
import com.antoniolage.cleantmdb.presentation.di.core.*
import com.antoniolage.cleantmdb.presentation.di.movie.MovieSubComponent
import com.antoniolage.cleantmdb.presentation.di.people.PersonSubComponent
import com.antoniolage.cleantmdb.presentation.di.tvshow.TVShowSubComponent

class App:Application(), Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
appComponent= DaggerAppComponent.builder()
    .appModule(AppModule(applicationContext))
    .netModule(NetModule(BuildConfig.BASE_URL))
    .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
    .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
      return appComponent.movieSubComponent().create()

           }

    override fun tvShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createPersonSubComponent(): PersonSubComponent {
        return appComponent.PersonSubComponent().create()
    }
}