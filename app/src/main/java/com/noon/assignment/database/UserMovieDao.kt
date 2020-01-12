package com.noon.assignment.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface UserMovieDao {

    @Query("select * from user_movie order by bookmarked desc, imdb_id")
    fun loadAll(): Flowable<List<UserMovie>>

    @Query("select * from user_movie where imdb_id = :imdbId LIMIT 1")
    fun loadByimdbId(imdbId: String): Maybe<UserMovie>

    @Insert(onConflict = REPLACE)
    fun insert(userMovie: UserMovie)

    @Delete
    fun delete(userMovie: UserMovie)

    @Query("delete from user_movie")
    fun deleteAll()
}
