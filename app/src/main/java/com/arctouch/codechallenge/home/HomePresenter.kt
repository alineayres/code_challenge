package com.arctouch.codechallenge.home

import android.view.View
import com.arctouch.codechallenge.api.ApiClient
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.data.Cache
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter(){

    lateinit var view: HomeActivity

    fun getUpcomingMovies() {
        ApiClient.getService().upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, 1, TmdbApi.DEFAULT_REGION)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    val moviesWithGenres = it.results.map {
                        movie -> movie.copy(genres = Cache.genres.filter {
                        genre -> movie.genreIds?.contains(genre.id) == true
                        })
                    }

                    view.setAdapter(moviesWithGenres)
                    view.hideProgressBar()
                }
    }
}