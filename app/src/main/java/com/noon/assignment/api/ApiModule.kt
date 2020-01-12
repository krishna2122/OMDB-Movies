package com.noon.assignment.api

import com.noon.assignment.BuildConfig
import com.noon.assignment.api.MoviesClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideMoviesClient(): MoviesClient = MoviesClient(BuildConfig.BASE_URL, BuildConfig.API_KEY)
}
