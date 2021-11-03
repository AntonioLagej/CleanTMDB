package com.antoniolage.cleantmdb.data.repository.movie.datasourceimpl

import android.util.Log
import com.antoniolage.cleantmdb.data.model.movies.Movie
import com.antoniolage.cleantmdb.data.model.movies.MovieList
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieCacheDatasource
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieLocalDatasource
import com.antoniolage.cleantmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.antoniolage.cleantmdb.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieCacheDatasource: MovieCacheDatasource,
    private val movieLocalDatasource: MovieLocalDatasource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
    return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {

    val newListofMovies=getMoviesFromAPI()
    movieLocalDatasource.clearAll()
    movieLocalDatasource.saveMoviesToDB(newListofMovies)
    movieCacheDatasource.saveMoviesToCache(newListofMovies)
    return newListofMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList: List<Movie>
   return try {
        val response=movieRemoteDatasource.getMovies()
        val body= response.body()

        if(body!=null){

            movieList=body.movies
            Log.i("mytag",   "is successful "+ body.totalResults)
            movieList
        }else{
          emptyList()
        }



    }catch (e:Exception){
        Log.i("mytag",e.message.toString())
        emptyList()
    }


    }
    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
        movieList= movieLocalDatasource.getMoviesFromDB()


        }catch (e:Exception){
            Log.i("Mytag",e.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else
        {
            movieList=getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }

        return movieList
    }
    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList= movieCacheDatasource.getMoviesFromCache()


        }catch (e:Exception){
            Log.i("Mytag",e.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else
        {
                movieList=getMoviesFromDB()
                movieCacheDatasource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}