package com.akshay.newsapp.repo

import android.arch.lifecycle.LiveData
import com.akshay.newsapp.AppExecutors
import com.akshay.newsapp.api.ApiResponse
import com.akshay.newsapp.api.NewsSourceService
import com.akshay.newsapp.db.NewsArticlesDao
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.NewsSource
import com.akshay.newsapp.model.Resource

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 *
 * @author Akshay Chordiya
 * @since 6/5/2017.
 */
class NewsRepository(val newsDao: NewsArticlesDao, val newsSourceService: NewsSourceService, val appExecutors: AppExecutors = AppExecutors()) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getNewsArticles(): LiveData<Resource<List<NewsArticles>>> {
        return object : NetworkBoundResource<List<NewsArticles>, NewsSource>(appExecutors) {
            override fun saveCallResult(item: NewsSource) {
                newsDao.insertArticles(item.articles)
            }

            override fun shouldFetch(data: List<NewsArticles>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<NewsArticles>> {
                return newsDao.getNewsArticles()
            }

            override fun createCall(): LiveData<ApiResponse<NewsSource>> {
                return newsSourceService.getNewsSource()
            }
        }.asLiveData()
    }

}