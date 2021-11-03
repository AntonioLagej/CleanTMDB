package com.antoniolage.cleantmdb.data.api

import com.antoniolage.cleantmdb.data.model.movies.MovieList
import com.antoniolage.cleantmdb.data.model.people.PeopleList
import com.antoniolage.cleantmdb.data.model.tvshows.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
suspend fun getPopularMovies(@Query("api_key")apiKey:String):Response<MovieList>

    @GET("person/popular")
    suspend fun getPopularPerson(@Query("api_key")apiKey:String):Response<PeopleList>
    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key")apiKey:String):Response<TVShowList>


}
