package com.akshay.newsapp.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.akshay.newsapp.model.NewsArticles

/**
 * The component to separate the data and UI part.
 * It even survives configuration changes.
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class NewsArticleListViewModel(application: Application?) : AndroidViewModel(application) {

    /**
     * The data held for UI
     */
    private val newsArticlesList: NewsArticleLiveData = NewsArticleLiveData()

    /**
     * Get live data reference of all the news articles to observe for changes
     */
    fun getNewsArticles(): LiveData<List<NewsArticles>> {
        return newsArticlesList
    }
}