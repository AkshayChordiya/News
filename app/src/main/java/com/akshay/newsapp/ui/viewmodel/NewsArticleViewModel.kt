package com.akshay.newsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.ViewState
import com.akshay.newsapp.repo.NewsRepository

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
class NewsArticleViewModel constructor(
         newsRepository: NewsRepository
) : ViewModel() {

    private val newsArticles: LiveData<ViewState<List<NewsArticles>>> = newsRepository.getNewsArticles().asLiveData()

    /**
     * Return news articles to observeNotNull on the UI.
     */
    fun getNewsArticles(): LiveData<ViewState<List<NewsArticles>>> = newsArticles
}