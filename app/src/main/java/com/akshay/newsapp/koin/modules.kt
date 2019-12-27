package com.akshay.newsapp.koin

import com.akshay.newsapp.db.NewsDatabase
import com.akshay.newsapp.repo.NewsRepository
import com.akshay.newsapp.ui.viewmodel.NewsArticleViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

	// Retrofit Instance
	single {
		retrofit()
	}

	// NewsDatabase Instance
	single {
		NewsDatabase.buildDefault(androidApplication())
	}

	// NewsArticleDao instance
	single {
		get<NewsDatabase>().newsArticlesDao()
	}

	// NewsRepository instance
	single {
		NewsRepository(get(), get())
	}

	// NewdArticleViewModel instance
	viewModel {
		NewsArticleViewModel(get())
	}
}

private fun retrofit(): Retrofit {
	return Retrofit.Builder().baseUrl("https://newsapi.org/v1/")
		.addConverterFactory(GsonConverterFactory.create()).build()
}

