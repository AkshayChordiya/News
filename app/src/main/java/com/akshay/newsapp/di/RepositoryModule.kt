package com.akshay.newsapp.di

import com.akshay.newsapp.repo.NewsRepository
import org.koin.dsl.module

/**
 * Repository initializations
 */
val repositoryModule = module {

	single {
		NewsRepository(get(), get())
	}

}