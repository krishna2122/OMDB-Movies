package com.noon.assignment.database

import androidx.room.*
import com.noon.assignment.database.Bookmark
import io.reactivex.Maybe

@Dao
interface BookmarkDao {

    @Query("select * from bookmark where imdb_id = :imdbId LIMIT 1")
    fun loadByimdbId(imdbId: String): Maybe<Bookmark>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookmark: Bookmark)

    @Delete
    fun delete(bookmark: Bookmark)

    @Query("delete from bookmark")
    fun deleteAll()
}
