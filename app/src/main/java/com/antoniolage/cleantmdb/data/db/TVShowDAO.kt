package com.antoniolage.cleantmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.antoniolage.cleantmdb.data.model.tvshows.TVShow

@Dao
interface TVShowDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows:List<TVShow>)
    @Query("DELETE FROM TVShow")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM TVShow")
    suspend fun getTvShows():List<TVShow>
}