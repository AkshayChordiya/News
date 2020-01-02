package com.akshay.newsapp

import android.app.Application
import com.akshay.newsapp.koin.AppInjector

class NewsApp : Application() {

	override fun onCreate() {
		super.onCreate()

		// Init DI magic ✨
		AppInjector.init(this)

	}
}
