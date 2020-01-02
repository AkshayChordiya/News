package com.akshay.newsapp.di

import com.akshay.newsapp.api.NewsService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * All network related initializations
 */
val newsServiceModule = module {

	single {
		retrofit()
	}

	single { get<Retrofit>().create(NewsService::class.java) }

}

private fun retrofit(): Retrofit {
	return Retrofit.Builder().baseUrl("https://newsapi.org/v1/")
		.addConverterFactory(GsonConverterFactory.create()).build()
}
