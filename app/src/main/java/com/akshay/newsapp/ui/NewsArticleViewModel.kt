package com.akshay.newsapp.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.network.Resource
import com.akshay.newsapp.repo.NewsRepository

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
class NewsArticleViewModel(newsRepository: NewsRepository) : ViewModel() {

    private var newsArticles: LiveData<Resource<List<NewsArticles>?>> = newsRepository.getNewsArticles()

    /**
     * Return news articles to observe on the UI.
     */
    fun getNewsArticles() = newsArticles
}