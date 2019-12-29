package com.akshay.newsapp.koin

import com.akshay.newsapp.NewsApp
import com.akshay.newsapp.koin.modules.newsDatabaseModule
import com.akshay.newsapp.koin.modules.newsServiceModule
import com.akshay.newsapp.koin.modules.repositoryModule
import com.akshay.newsapp.koin.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
 * Helper class to create an abstraction layer over the DI technique used in the app
 */

object AppInjector {

	/**
	 * Initialize Koin magic ✨
	 */

	fun init(app: NewsApp) {
		startKoin {
			// Android context
			androidContext(app)
			// modules
			modules(
				listOf(
					newsDatabaseModule, newsServiceModule, viewModelModule, repositoryModule
				)
			)
		}
	}
}