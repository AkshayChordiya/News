package com.akshay.newsapp.news.domain

import com.akshay.newsapp.core.domain.NetworkBoundResource
import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.news.api.NewsService
import com.akshay.newsapp.news.model.NewsArticles
import com.akshay.newsapp.news.model.NewsSourceResponse
import com.akshay.newsapp.news.storage.NewsArticlesDao
import dagger.Binds
import dagger.Module
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 */
interface NewsRepository {

    /**
     * Gets tne cached news article from database and tries to get
     * fresh news articles from web and save into database
     * if that fails then continues showing cached data.
     */
    fun getNewsArticles(): Flow<ViewState<List<NewsArticles>>>
}

@Singleton
class DefaultNewsRepository @Inject constructor(
        private val newsDao: NewsArticlesDao,
        private val newsService: NewsService
) : NewsRepository {

    override fun getNewsArticles(): Flow<ViewState<List<NewsArticles>>> {
        return object : NetworkBoundResource<List<NewsArticles>, NewsSourceResponse>() {
            override suspend fun saveNetworkResult(response: NewsSourceResponse) = newsDao.clearAndCacheArticles(response.articles)
            // Always try to fetch new articles
            override fun shouldFetch(data: List<NewsArticles>?): Boolean = true
            override fun loadFromDb(): Flow<List<NewsArticles>> = newsDao.getNewsArticles()
            override suspend fun fetchFromNetwork(): Response<NewsSourceResponse> = newsService.getNewsFromGoogle()
        }
        .asFlow()
        .flowOn(Dispatchers.IO)
    }
}

@Module
interface NewsRepositoryModule {
    /* Exposes the concrete implementation for the interface */
    @Binds fun it(it: DefaultNewsRepository): NewsRepository
}