package com.arctouch.codechallenge.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiClient {
    companion object {
        fun getService(): TmdbApi {
                val  retrofit = Retrofit.Builder()
                        .baseUrl(TmdbApi.URL)
                        .addConverterFactory(MoshiConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(OkHttpClient.Builder().build())
                        .build()
            return retrofit.create(TmdbApi::class.java)
        }
    }

}