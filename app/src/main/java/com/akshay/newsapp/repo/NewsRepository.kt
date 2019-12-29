package com.akshay.newsapp.repo

import com.akshay.newsapp.api.NewsService
import com.akshay.newsapp.db.NewsArticlesDao
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 */
class NewsRepository constructor(
        private val newsDao: NewsArticlesDao,
        private val newsService: NewsService
) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getNewsArticles(): Flow<ViewState<List<NewsArticles>>> {
        return flow {
            // 1. Start with loading + data from database
            emit(ViewState.loading())
            emit(ViewState.success(newsDao.getNewsArticles()))

            // 2. Try fetching new news -> save + emit
            val newsSource = newsService.getNewsFromGoogle()
            newsDao.insertArticles(newsSource.articles)

            // 3. Get articles from database [Single source of truth]
            emit(ViewState.success(newsDao.getNewsArticles()))
        }.catch {
            emit(ViewState.error(it.message.orEmpty()))
        }.flowOn(Dispatchers.IO)
    }

}