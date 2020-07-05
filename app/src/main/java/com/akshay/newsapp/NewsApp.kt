package com.akshay.newsapp

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject


class NewsApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        // Init DI magic ✨
        AppInjector.init(this)
        // Plant timber
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}