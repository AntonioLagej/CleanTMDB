package com.antoniolage.cleantmdb.presentation.di.core

import android.util.Log
import com.antoniolage.cleantmdb.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {
    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        Log.i("Mytag","InsideNetModule ${baseUrl}")
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}