package com.noon.assignment.moviedetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.noon.assignment.R
import com.noon.assignment.moviedetails.mvp.MovieDetailsPresenter
import com.noon.assignment.moviedetails.mvp.view.MovieDetailsView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_movie_details.*
import java.lang.Exception
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER_MOVIE = "user_movie"
    }

    @Inject
    lateinit var view: MovieDetailsView

    @Inject
    lateinit var presenter: MovieDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            AndroidInjection.inject(this)
            super.onCreate(savedInstanceState)
            setContentView(view)
            setSupportActionBar(toolbar as Toolbar?)
            supportActionBar?.setTitle(R.string.empty_string)



            presenter.onCreate()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
