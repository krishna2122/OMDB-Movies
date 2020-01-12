package com.noon.assignment.app


import com.noon.assignment.main.MainActivity
import com.noon.assignment.main.MainModule
import com.noon.assignment.main.MainScope

import com.noon.assignment.moviedetails.MovieDetailsActivity
import com.noon.assignment.moviedetails.MovieDetailsModule
import com.noon.assignment.moviedetails.MovieDetailsScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @MainScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

    @MovieDetailsScope
    @ContributesAndroidInjector(modules = [MovieDetailsModule::class])
    abstract fun bindMovieDetailsActivity(): MovieDetailsActivity
}
