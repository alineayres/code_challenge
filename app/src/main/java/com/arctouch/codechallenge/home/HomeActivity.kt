package com.arctouch.codechallenge.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.model.Movie
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.home_activity.*
import javax.inject.Inject

class HomeActivity(): AppCompatActivity() {
    private val presenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        presenter.view = this
        presenter.getUpcomingMovies()
    }

    fun setAdapter(moviesWithGenres: List<Movie>) {
        recyclerView.adapter = HomeAdapter(moviesWithGenres)
    }

    fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}

