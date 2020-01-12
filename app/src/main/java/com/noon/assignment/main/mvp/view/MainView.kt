package com.noon.assignment.main.mvp.view

import com.noon.assignment.database.UserMovie

interface MainView {

    fun showUserMovies(userMovies: List<UserMovie>)

    fun showNoUserMovies()

    fun showError()

    fun showLoading()
}
