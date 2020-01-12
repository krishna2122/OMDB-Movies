package com.noon.assignment.moviedetails

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.noon.assignment.main.mvp.view.MoviesAdapter


import com.noon.assignment.database.UserMovie
import com.noon.assignment.main.mvp.view.MainView

class SearchResultsActivity : AppCompatActivity(), MoviesAdapter.OnMovieClicked, MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Log.d("TAG",)

    }



    override fun onClick(userMovie: UserMovie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUserMovies(userMovies: List<UserMovie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoUserMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}