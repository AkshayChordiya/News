package com.akshay.newsapp.di.base

import com.akshay.newsapp.NewsApp
import com.akshay.newsapp.di.newsDatabaseModule
import com.akshay.newsapp.di.newsServiceModule
import com.akshay.newsapp.di.repositoryModule
import com.akshay.newsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
 * Helper class to create an abstraction layer over the DI technique used in the app
 */

object AppInjector {

	/**
	 * List of all the modules
	 */
	private val modules = listOf(
		newsDatabaseModule,
		newsServiceModule,
		viewModelModule,
		repositoryModule
	)

	/**
	 * Initialize Koin magic ✨
	 */

	fun init(app: NewsApp) {
		startKoin {
			androidContext(app)
			modules(modules)
		}
	}
}