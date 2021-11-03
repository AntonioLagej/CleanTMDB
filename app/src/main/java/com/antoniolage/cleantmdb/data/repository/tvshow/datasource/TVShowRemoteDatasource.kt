package com.antoniolage.cleantmdb.data.repository.tvshow.datasource

import com.antoniolage.cleantmdb.data.model.tvshows.TVShowList
import retrofit2.Response

interface TVShowRemoteDatasource {
    suspend fun getTvShows():Response<TVShowList>

}