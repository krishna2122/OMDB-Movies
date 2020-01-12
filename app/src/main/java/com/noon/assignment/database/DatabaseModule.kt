package com.noon.assignment.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMoviesDatabase(context: Context): MoviesDatabase =
            Room.databaseBuilder(context, MoviesDatabase::class.java, "movies.db")
                    .build()
}
