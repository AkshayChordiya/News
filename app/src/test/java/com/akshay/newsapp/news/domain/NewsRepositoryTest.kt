package com.akshay.newsapp.news.domain

import com.akshay.newsapp.news.api.NewsService
import com.akshay.newsapp.news.storage.NewsArticlesDao
import com.akshay.newsapp.news.storage.entity.NewsArticleDb
import com.akshay.newsapp.news.api.NewsResponse
import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.core.utils.MockitoTest
import com.akshay.newsapp.core.utils.assertItems
import com.akshay.newsapp.news.api.NewsArticle
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import retrofit2.Response

@RunWith(JUnit4::class)
class NewsRepositoryTest : MockitoTest() {

    @Mock
    lateinit var newsDao: NewsArticlesDao

    @Mock
    lateinit var newsSourceService: NewsService

    @InjectMocks
    lateinit var newsRepository: DefaultNewsRepository

    @Test
    fun `get news articles from web when there is internet`() = runBlocking {
        // GIVEN
        val fetchedArticles = listOf(NewsArticle(title = "Fetched 1"), NewsArticle(title = "Fetched 2"))
        val cachedArticles = listOf(NewsArticleDb(title = "Fetched 1"), NewsArticleDb(title = "Fetched 2"))
        val newsSource = NewsResponse(articles = fetchedArticles)
        val response = Response.success(newsSource)

        // WHEN
        whenever(newsSourceService.getNewsFromGoogle()) doReturn response
        whenever(newsDao.getNewsArticles()) doReturn flowOf(cachedArticles)

        // THEN
        newsRepository.getNewsArticles().assertItems(
                ViewState.loading(),
                ViewState.success(cachedArticles)
        )
    }

    @Test
    fun `get cached news articles when there is no internet`() = runBlocking {
        // GIVEN
        val cachedArticles = listOf(NewsArticleDb(title = "Cached"))
        val error = RuntimeException("Unable to fetch from network")

        // WHEN
        whenever(newsSourceService.getNewsFromGoogle()) doThrow error
        whenever(newsDao.getNewsArticles()) doReturn flowOf(cachedArticles)

        // THEN
        newsRepository.getNewsArticles().assertItems(
                ViewState.loading(),
                ViewState.success(cachedArticles)
        )
    }
}