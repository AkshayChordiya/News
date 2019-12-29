package com.akshay.newsapp.koin.modules

import com.akshay.newsapp.db.NewsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * All database related initializations
 */

val newsDatabaseModule = module {

	// NewsDatabase Instance
	single {
		NewsDatabase.buildDefault(androidApplication())
	}

	// NewsArticleDao instance
	single {
		get<NewsDatabase>().newsArticlesDao()
	}

}