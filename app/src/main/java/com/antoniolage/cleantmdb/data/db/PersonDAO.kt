package com.antoniolage.cleantmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.antoniolage.cleantmdb.data.model.people.Person

@Dao
interface PersonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePeople(People:List<Person>)
    @Query("DELETE FROM person")
    suspend fun deleteAllPeople()

    @Query("SELECT * FROM person")
    suspend fun getPeople():List<Person>
}