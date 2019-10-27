package com.akshay.newsapp.repo

import com.akshay.newsapp.api.NewsSourceService
import com.akshay.newsapp.db.NewsArticlesDao
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 *
 * @author Akshay Chordiya
 * @since 6/5/2017.
 */

@Singleton
class NewsRepository @Inject constructor(
        private val newsDao: NewsArticlesDao,
        private val newsSourceService: NewsSourceService
) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getNewsArticles(): Flow<Resource<List<NewsArticles>>> {
        return flow {
            emit(Resource.loading())
            // Fetch + Save articles into DB
            val newsSource = newsSourceService.getNewsSource()
            newsDao.insertArticles(newsSource.articles)
            // Get articles from database [Single source of truth]
            val articles = newsDao.getNewsArticles()
            emit(Resource.success(articles))
        }.flowOn(Dispatchers.IO)
    }

}