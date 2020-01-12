package com.noon.assignment.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark")
data class Bookmark(
        @PrimaryKey
        @ColumnInfo(name = "imdb_id")
        val imdbId: String)
