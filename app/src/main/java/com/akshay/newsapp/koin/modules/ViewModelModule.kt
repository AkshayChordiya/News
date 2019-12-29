package com.akshay.newsapp.koin.modules

import com.akshay.newsapp.ui.viewmodel.NewsArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * ViewModel initializations
 */

val viewModelModule = module {

	// NewdArticleViewModel instance
	viewModel {
		NewsArticleViewModel(get())
	}

}