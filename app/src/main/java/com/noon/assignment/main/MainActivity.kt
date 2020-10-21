package com.noon.assignment.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import dagger.android.AndroidInjection
import javax.inject.Inject
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.noon.assignment.R
import com.noon.assignment.main.mvp.MainPresenter
import com.noon.assignment.database.UserMovie
import com.noon.assignment.main.mvp.view.MainView
import com.noon.assignment.main.mvp.view.MoviesAdapter
import com.noon.assignment.moviedetails.MovieDetailsActivity


class MainActivity : AppCompatActivity(), MoviesAdapter.OnMovieClicked, MainView {



    private lateinit var mRecyclerView: RecyclerView
    private lateinit var emptyTextView: TextView
    private lateinit var errorTextView: TextView
    private lateinit var indeterminateBar: ProgressBar

    private lateinit var mMoviesAdapter: MoviesAdapter

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler_view)
        emptyTextView = findViewById(R.id.empty)
        errorTextView = findViewById(R.id.error)
        
        println()
        indeterminateBar = findViewById(R.id.indeterminateBar)
        mMoviesAdapter = MoviesAdapter(this, this)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mMoviesAdapter
        var itemDevide: DividerItemDecoration =DividerItemDecoration(this,HORIZONTAL)
        val horizontalDevider = ContextCompat.getDrawable(this, R.drawable.horizontal_seperator)
        itemDevide.setDrawable(horizontalDevider!!)
        mRecyclerView.addItemDecoration( itemDevide);
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showUserMovies(userMovies: List<UserMovie>) {
        mMoviesAdapter.setData(userMovies)
        emptyTextView.visibility = View.INVISIBLE
        errorTextView.visibility = View.INVISIBLE
        indeterminateBar.visibility = View.INVISIBLE
        mRecyclerView.visibility = View.VISIBLE
    }

    override fun showNoUserMovies() {
        mRecyclerView.visibility = View.INVISIBLE
        errorTextView.visibility = View.INVISIBLE
        indeterminateBar.visibility = View.INVISIBLE
        emptyTextView.visibility = View.VISIBLE
    }

    override fun showError() {
        mRecyclerView.visibility = View.INVISIBLE
        emptyTextView.visibility = View.INVISIBLE
        indeterminateBar.visibility = View.INVISIBLE
        errorTextView.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mRecyclerView.visibility = View.INVISIBLE
        emptyTextView.visibility = View.INVISIBLE
        errorTextView.visibility = View.INVISIBLE
        indeterminateBar.visibility = View.VISIBLE
    }

    override fun onClick(userMovie: UserMovie) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MovieDetailsActivity.EXTRA_USER_MOVIE, userMovie)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView? = searchItem?.actionView as SearchView

        println("this was great expereince ")

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return super.onCreateOptionsMenu(menu)
    }
}
