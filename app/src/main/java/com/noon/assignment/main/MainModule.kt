package com.noon.assignment.main

import com.noon.assignment.database.MoviesDatabase

import com.noon.assignment.api.MoviesClient
import com.noon.assignment.main.mvp.MainModel
import com.noon.assignment.main.mvp.MainPresenter
import com.noon.assignment.main.mvp.view.MainView
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideModel(database: MoviesDatabase, client: MoviesClient) = MainModel(database, client)

    @MainScope
    @Provides
    fun provideView(activity: MainActivity) = activity as MainView

    @MainScope
    @Provides
    fun providePresenter(model: MainModel, view: MainView) = MainPresenter(model, view)
}
