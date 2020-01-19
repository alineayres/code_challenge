package com.arctouch.codechallenge.home

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.model.Movie
import com.arctouch.codechallenge.util.MovieImageUrlBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.detail_activity.*
import kotlinx.android.synthetic.main.movie_item.view.*

class DetailActivity: AppCompatActivity() {

    private val movieImageUrlBuilder = MovieImageUrlBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val movie = intent.extras?.getSerializable("movie_info") as Movie
        setupMovieDetails(movie)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun setupMovieDetails(movie: Movie) {
        Glide.with(detailPosterImageView)
                .load(movie.posterPath?.let { movieImageUrlBuilder.buildPosterUrl(it) })
                .apply(RequestOptions().placeholder(R.drawable.ic_image_placeholder))
                .into(detailPosterImageView)

        detailTitleTextView.text = movie.title
        detailOverviewTextView.text = movie.overview
        detailGenresTextView.text = movie.genres?.joinToString(separator = ", ") { it.name }
        detailReleaseDateTextView.text = movie.releaseDate

        Glide.with(backDropPathImageView)
                .load(movie.backdropPath?.let { movieImageUrlBuilder.buildBackdropUrl(it) })
                .into(backDropPathImageView)
    }
}
