package com.akshay.newsapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.akshay.newsapp.api.NewsSourceService
import com.akshay.newsapp.db.DatabaseCreator
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.network.Resource
import com.akshay.newsapp.repo.NewsRepository

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
class NewsArticleViewModel(application: Application) : AndroidViewModel(application) {

    private var newsArticles: LiveData<Resource<List<NewsArticles>?>>

    init {
        // TODO: Inject repository using DI.
        val newsRepository = NewsRepository(
                DatabaseCreator.database(application).newsArticlesDao(),
                NewsSourceService.getNewsSourceService()
        )
        newsArticles = newsRepository.getNewsArticles()
    }

    /**
     * Return news articles to observe on the UI.
     */
    fun getNewsArticles() = newsArticles
}