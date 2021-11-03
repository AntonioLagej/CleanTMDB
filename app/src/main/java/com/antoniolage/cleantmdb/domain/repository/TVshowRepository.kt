package com.antoniolage.cleantmdb.domain.repository

import com.antoniolage.cleantmdb.data.model.tvshows.TVShow

interface TVshowRepository {
    suspend fun getTVshows():List<TVShow>?
    suspend fun updateTVshows():List<TVShow>?

}