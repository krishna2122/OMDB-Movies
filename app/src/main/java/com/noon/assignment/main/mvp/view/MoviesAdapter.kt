package com.noon.assignment.main.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.noon.assignment.R
import com.noon.assignment.database.UserMovie
import com.squareup.picasso.Picasso
import java.util.*

class MoviesAdapter(private val mContext: Context, private val mListener: OnMovieClicked) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    //companion object {

        class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val mTitle: TextView = view.findViewById(R.id.title)
            val plot: TextView = view.findViewById(R.id.plot)
            val image: ImageView = view.findViewById(R.id.image)
            val bookmarked: ImageView = view.findViewById(R.id.bookmarked)
        }
    //}

    private var userMovies: List<UserMovie> = ArrayList()

    fun setData(data: List<UserMovie>) {
        userMovies = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesAdapter.MoviesViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = userMovies[position]
        holder.mTitle.text = item.title
        holder.plot.text = item.plot
        Picasso.with(mContext).load(item.poster).fit().centerCrop().into(holder.image)
        holder.itemView.setOnClickListener { _ -> mListener.onClick(item) }
        holder.bookmarked.visibility = if (item.bookmarked) VISIBLE else GONE
        holder.bookmarked.setColorFilter(R.color.colorBookmarked)
    }

    override fun getItemCount(): Int {
        return userMovies.size
    }

    // TODO: Replace with RxView.clicks()
    interface OnMovieClicked {
        fun onClick(userMovie: UserMovie)
    }


}
