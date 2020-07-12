package com.akshay.newsapp.news.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.news.domain.NewsRepository
import com.akshay.newsapp.news.storage.entity.NewsArticleDb

/**
 * A container for [NewsArticleDb] related data to show on the UI.
 */
class NewsArticleViewModel @ViewModelInject constructor(
        newsRepository: NewsRepository
) : ViewModel() {

    private val newsArticleDb: LiveData<ViewState<List<NewsArticleDb>>> = newsRepository.getNewsArticles().asLiveData()

    /**
     * Return news articles to observeNotNull on the UI.
     */
    fun getNewsArticles(): LiveData<ViewState<List<NewsArticleDb>>> = newsArticleDb
}