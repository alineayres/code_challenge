package com.arctouch.codechallenge

import android.app.Application
import android.content.Intent
import com.arctouch.codechallenge.api.ApiClient
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.home.HomeActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CodeChallengeApplication : Application(){

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
