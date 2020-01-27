package com.arctouch.codechallenge

import android.app.Application
import com.arctouch.codechallenge.api.ApiClient
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.dagger.CodeChallengeComponent
import com.arctouch.codechallenge.dagger.CodeChallengeModule
import com.arctouch.codechallenge.dagger.DaggerCodeChallengeComponent
import com.arctouch.codechallenge.dagger.DaggerComponent
import com.arctouch.codechallenge.data.Cache
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CodeChallengeApplication : Application() {

    companion object {
        lateinit var instance: CodeChallengeApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this


        ApiClient.getService().genres(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Cache.cacheGenres(it.genres)
                }

    }
}
