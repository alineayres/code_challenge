package com.arctouch.codechallenge.dagger

import com.arctouch.codechallenge.home.HomeActivity
import com.arctouch.codechallenge.home.HomePresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CodeChallengeModule {

    @Provides
    fun provideHomePresenter(): HomePresenter = HomePresenter()


}
