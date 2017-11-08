package com.akshay.newsapp.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.akshay.newsapp.api.NewsSourceService
import com.akshay.newsapp.db.DatabaseCreator
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.Resource
import com.akshay.newsapp.repo.NewsRepository

/**
 * The component to separate the data and UI part.
 * It survives configuration changes and abstracts the logic
 * of fetching the data
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class NewsArticleViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * The live data held
     */
    private var newsArticles: LiveData<Resource<List<NewsArticles>>>

    init {
        val newsRepository = NewsRepository(DatabaseCreator.database(application).newsArticlesDao(), NewsSourceService.getNewsSourceService())
        newsArticles = newsRepository.getNewsArticles()
    }

    /**
     * Get live data reference of all the news articles to observe for changes
     */
    fun getNewsArticles(): LiveData<Resource<List<NewsArticles>>> {
        return newsArticles
    }
}