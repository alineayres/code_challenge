package com.arctouch.codechallenge.test

import com.arctouch.codechallenge.home.HomeActivity
import com.arctouch.codechallenge.home.HomePresenter
import com.arctouch.codechallenge.model.Movie
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController


@RunWith(RobolectricTestRunner::class)
class HomePresenterTest {

    lateinit var homeActivity: HomeActivity

    private lateinit var homePresenter: HomePresenter

    @Before
    fun setUp() {
        homeActivity = Robolectric.setupActivity(HomeActivity::class.java)
        initMocks(this)
        homePresenter = HomePresenter()
        homePresenter.view = homeActivity
    }

    @Test
    fun shouldSetAdapterOnViewWhenCallUpcomingMoviesFromPresenter() {
        val expectedMovieList = listOf<Movie>(Movie(1, "Titanic", null, null, null, null, null, null))
        homePresenter.getUpcomingMovies()

//        verify(homeActivity).setAdapter(expectedMovieList)
    }
}