package com.akshay.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.network.Resource
import com.akshay.newsapp.repo.NewsRepository
import javax.inject.Inject

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
class NewsArticleViewModel @Inject constructor(
        newsRepository: NewsRepository
) : ViewModel() {

    private val newsArticles: LiveData<Resource<List<NewsArticles>>> = newsRepository.getNewsArticles().asLiveData()

    /**
     * Return news articles to observe on the UI.
     */
    fun getNewsArticles(): LiveData<Resource<List<NewsArticles>>> = newsArticles
}