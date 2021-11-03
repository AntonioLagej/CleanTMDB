package com.antoniolage.cleantmdb.data.repository.tvshow.datasource

import com.antoniolage.cleantmdb.data.model.tvshows.TVShow

interface TVShowLocalDatasource {
    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(tVShow: List<TVShow>)
    suspend fun clearAll()
}