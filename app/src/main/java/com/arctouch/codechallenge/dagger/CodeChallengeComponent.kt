package com.arctouch.codechallenge.dagger

import android.app.Application
import com.arctouch.codechallenge.CodeChallengeApplication
import com.arctouch.codechallenge.home.HomeActivity
import com.arctouch.codechallenge.home.HomePresenter
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [ AndroidSupportInjectionModule::class, CodeChallengeModule::class, AndroidModule::class])
interface CodeChallengeComponent: AndroidInjector<CodeChallengeApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CodeChallengeComponent

    }
    fun injectApplication(app: CodeChallengeApplication)
}
