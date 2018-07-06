package com.akshay.newsapp.repo

import androidx.lifecycle.LiveData
import com.akshay.newsapp.AppExecutors
import com.akshay.newsapp.api.NewsSourceService
import com.akshay.newsapp.db.NewsArticlesDao
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.NewsSource
import com.akshay.newsapp.model.network.Resource

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 *
 * @author Akshay Chordiya
 * @since 6/5/2017.
 */
class NewsRepository(
        private val newsDao: NewsArticlesDao,
        private val newsSourceService: NewsSourceService,
        private val appExecutors: AppExecutors = AppExecutors()
) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getNewsArticles(): LiveData<Resource<List<NewsArticles>?>> {
        return object : NetworkBoundResource<List<NewsArticles>, NewsSource>(appExecutors) {
            override fun saveCallResult(item: NewsSource) {
                newsDao.insertArticles(item.articles)
            }

            override fun shouldFetch(data: List<NewsArticles>?) = true

            override fun loadFromDb() = newsDao.getNewsArticles()

            override fun createCall() = newsSourceService.getNewsSource()
        }.asLiveData()
    }

}