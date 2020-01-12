package com.noon.assignment.moviedetails.mvp

import com.noon.assignment.database.Bookmark
import com.noon.assignment.database.MoviesDatabase
import com.noon.assignment.database.UserMovie
import io.reactivex.Observable

class MovieDetailsModel(private val database: MoviesDatabase, val userMovie: UserMovie) {

    fun bookmarkMovie(): Observable<Any> =
            Observable.create<Any> {
                database.bookmarkDao().insert(Bookmark(userMovie.imdbId))
                database.userMovieDao().insert(UserMovie(
                        userMovie.imdbId, userMovie.title, userMovie.actors, userMovie.plot,
                        userMovie.imdbRating, userMovie.poster, true))
                if (!it.isDisposed) {
                    it.onNext(0)
                }
            }

    fun unBookmarkMovie(): Observable<Any> =
            Observable.create<Any> {
                database.bookmarkDao().delete(Bookmark(userMovie.imdbId))
                database.userMovieDao().insert(UserMovie(
                        userMovie.imdbId, userMovie.title, userMovie.actors, userMovie.plot,
                        userMovie.imdbRating, userMovie.poster, false))
                if (!it.isDisposed) {
                    it.onNext(0)
                }
            }
}
