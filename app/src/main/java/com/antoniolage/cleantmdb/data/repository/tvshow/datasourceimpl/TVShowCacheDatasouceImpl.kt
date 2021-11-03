package com.antoniolage.cleantmdb.data.repository.tvshow.datasourceimpl

import com.antoniolage.cleantmdb.data.model.tvshows.TVShow
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowCacheDatasource

class TVShowCacheDatasouceImpl: TVShowCacheDatasource {
   private var tvShowList= ArrayList<TVShow>()

    override suspend fun getTVShowsFromCache(): List<TVShow> {


      return tvShowList
    }

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList= ArrayList(tvShows)
    }
}