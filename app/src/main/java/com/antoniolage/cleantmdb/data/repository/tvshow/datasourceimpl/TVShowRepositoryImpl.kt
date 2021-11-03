package com.antoniolage.cleantmdb.data.repository.tvshow.datasourceimpl

import android.util.Log
import com.antoniolage.cleantmdb.data.model.tvshows.TVShow
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowCacheDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowLocalDatasource
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowRemoteDatasource
import com.antoniolage.cleantmdb.domain.repository.TVshowRepository
import java.lang.Exception

class TVShowRepositoryImpl(
    private val tvShowRemoteDatasource: TVShowRemoteDatasource,
    private val tvShowCacheDatasource: TVShowCacheDatasource,
    private val tvShowLocalDatasource: TVShowLocalDatasource

): TVshowRepository {

    override suspend fun getTVshows(): List<TVShow> {
        return getTVshowFromCache()
    }

    override suspend fun updateTVshows(): List<TVShow>? {

    val newListOfTVShows=getTVShowFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTVShowsToDB(newListOfTVShows)
        tvShowCacheDatasource.saveTVShowsToCache(newListOfTVShows)
    return newListOfTVShows
    }

    suspend fun getTVShowFromAPI():List<TVShow>{
        lateinit var tvShowList: List<TVShow>
    try {
        val response=tvShowRemoteDatasource.getTvShows()
        val body= response.body()
        if(body!=null){
            tvShowList=body.tvshows
        }

    }catch (e:Exception){
        Log.i("Mytag",e.message.toString())
    }

        return tvShowList
    }
    suspend fun getTVshowFromDB():List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList= tvShowLocalDatasource.getTVShowsFromDB()


        }catch (e:Exception){
            Log.i("Mytag",e.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        }else
        {
            tvShowList=getTVShowFromAPI()
            tvShowLocalDatasource.saveTVShowsToDB(tvShowList)
        }

        return tvShowList
    }
    suspend fun getTVshowFromCache():List<TVShow>{
        lateinit var tvshowList: List<TVShow>
        try {
            tvshowList= tvShowCacheDatasource.getTVShowsFromCache()


        }catch (e:Exception){
            Log.i("Mytag",e.message.toString())
        }
        if(tvshowList.isNotEmpty()){
            return tvshowList
        }else
        {
                tvshowList=getTVshowFromDB()
              tvShowCacheDatasource.saveTVShowsToCache(tvshowList)
        }

        return tvshowList
    }



}