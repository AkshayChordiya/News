package com.akshay.newsapp

import android.app.Application
import com.akshay.newsapp.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(applicationContext)
            // modules
            modules(appModule)
        }
    }
}