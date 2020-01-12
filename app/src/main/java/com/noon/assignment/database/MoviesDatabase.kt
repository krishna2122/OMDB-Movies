package com.noon.assignment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noon.assignment.database.Bookmark
import com.noon.assignment.database.BookmarkDao


@Database(entities = [UserMovie::class, Bookmark::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun userMovieDao(): UserMovieDao

    abstract fun bookmarkDao(): BookmarkDao
}
