package com.antoniolage.cleantmdb.data.repository.tvshow.datasource


import com.antoniolage.cleantmdb.data.model.tvshows.TVShow

interface TVShowCacheDatasource {
    suspend fun getTVShowsFromCache():List<TVShow>
    suspend fun saveTVShowsToCache(tVShow:List<TVShow>)

}