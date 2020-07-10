package com.akshay.newsapp.news.domain

import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.core.utils.httpError
import com.akshay.newsapp.news.api.NewsService
import com.akshay.newsapp.news.model.NewsArticles
import com.akshay.newsapp.news.model.NewsSourceResponse
import com.akshay.newsapp.news.storage.NewsArticlesDao
import dagger.Binds
import dagger.Module
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
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

    /**
     * Gets fresh news from web.
     */
    suspend fun getNewsFromWebservice(): Response<NewsSourceResponse>
}

@Singleton
class DefaultNewsRepository @Inject constructor(
        private val newsDao: NewsArticlesDao,
        private val newsService: NewsService
) : NewsRepository {

    override fun getNewsArticles(): Flow<ViewState<List<NewsArticles>>> = flow {
        // 1. Start with loading
        emit(ViewState.loading())

        // 2. Try to fetch fresh news from web + cache if any
        val freshNews = getNewsFromWebservice()
        freshNews.body()?.articles?.let(newsDao::clearAndCacheArticles)

        // 3. Get news from cache [cache is always source of truth]
        val cachedNews = newsDao.getNewsArticles()
        emitAll(cachedNews.map { ViewState.success(it) })
    }
    .flowOn(Dispatchers.IO)

    override suspend fun getNewsFromWebservice(): Response<NewsSourceResponse> {
        return try {
            newsService.getNewsFromGoogle()
        } catch (e: Exception) {
            httpError(404)
        }
    }
}

@Module
interface NewsRepositoryModule {
    /* Exposes the concrete implementation for the interface */
    @Binds fun it(it: DefaultNewsRepository): NewsRepository
}