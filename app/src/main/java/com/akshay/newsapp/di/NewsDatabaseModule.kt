package com.akshay.newsapp.di

import com.akshay.newsapp.db.NewsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * All database related initializations
 */
val newsDatabaseModule = module {

	single {
		NewsDatabase.buildDefault(androidApplication())
	}

	single {
		get<NewsDatabase>().newsArticlesDao()
	}

}