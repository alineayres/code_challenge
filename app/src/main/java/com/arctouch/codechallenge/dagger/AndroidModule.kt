package com.arctouch.codechallenge.dagger

import com.arctouch.codechallenge.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidModule {

    @ContributesAndroidInjector
    internal abstract fun injectHomeActivity(): HomeActivity

}
