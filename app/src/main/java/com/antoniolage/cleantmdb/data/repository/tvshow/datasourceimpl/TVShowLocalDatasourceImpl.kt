package com.antoniolage.cleantmdb.data.repository.tvshow.datasourceimpl

import com.antoniolage.cleantmdb.data.db.TVShowDAO

import com.antoniolage.cleantmdb.data.model.tvshows.TVShow
import com.antoniolage.cleantmdb.data.repository.tvshow.datasource.TVShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDatasourceImpl(private val tvShowDAO: TVShowDAO) : TVShowLocalDatasource {
    override suspend fun getTVShowsFromDB(): List<TVShow> {


      return tvShowDAO.getTvShows()
    }

    override suspend fun saveTVShowsToDB(tvshow: List<TVShow>) {


   CoroutineScope(Dispatchers.IO).launch {

       tvShowDAO.saveTVShows(tvshow)
   }
    }

    override suspend fun clearAll() {
      CoroutineScope(Dispatchers.IO).launch {
          tvShowDAO.deleteAllTvShows()
      }
    }
}