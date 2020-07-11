package com.akshay.newsapp.news.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.news.domain.NewsRepository
import com.akshay.newsapp.news.model.NewsArticles

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
class NewsArticleViewModel @ViewModelInject constructor(
        newsRepository: NewsRepository
) : ViewModel() {

    private val newsArticles: LiveData<ViewState<List<NewsArticles>>> = newsRepository.getNewsArticles().asLiveData()

    /**
     * Return news articles to observeNotNull on the UI.
     */
    fun getNewsArticles(): LiveData<ViewState<List<NewsArticles>>> = newsArticles
}