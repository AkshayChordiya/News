package com.akshay.newsapp.di

import com.akshay.newsapp.ui.viewmodel.NewsArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * ViewModel initializations
 */
val viewModelModule = module {

	viewModel {
		NewsArticleViewModel(get())
	}

}