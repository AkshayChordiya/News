package com.akshay.newsapp.koin.modules

import com.akshay.newsapp.api.NewsService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * All network related initializations
 */

val newsServiceModule = module {

	// Retrofit Instance
	single {
		retrofit()
	}

	// NewsService Instance
	single { get<Retrofit>().create(NewsService::class.java) }

}

private fun retrofit(): Retrofit {
	return Retrofit.Builder().baseUrl("https://newsapi.org/v1/")
		.addConverterFactory(GsonConverterFactory.create()).build()
}
