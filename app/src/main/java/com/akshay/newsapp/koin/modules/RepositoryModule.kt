package com.akshay.newsapp.koin.modules

import com.akshay.newsapp.repo.NewsRepository
import org.koin.dsl.module

/**
 * Repository initializations
 */

val repositoryModule = module {

	// NewsRepository instance
	single {
		NewsRepository(get(), get())
	}
}