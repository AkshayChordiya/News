package com.akshay.newsapp.news.domain

import com.akshay.newsapp.news.api.NewsService
import com.akshay.newsapp.news.storage.NewsArticlesDao
import com.akshay.newsapp.news.model.NewsArticles
import com.akshay.newsapp.news.model.NewsSourceResponse
import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.core.utils.MockitoTest
import com.akshay.newsapp.core.utils.assertItems
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doReturnConsecutively
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock

@RunWith(JUnit4::class)
class NewsRepositoryTest : MockitoTest() {

    @Mock
    lateinit var newsDao: NewsArticlesDao

    @Mock
    lateinit var newsSourceService: NewsService

    @InjectMocks
    lateinit var newsRepository: NewsRepository

    @Test
    fun `get news articles when there is internet`() = runBlocking {
        // GIVEN
        val cachedArticles = listOf(NewsArticles(title = "Cached"))
        val response = NewsSourceResponse(articles = listOf(NewsArticles(title = "Fetched")))

        // WHEN
        whenever(newsSourceService.getNewsFromGoogle()) doReturn response
        whenever(newsDao.getNewsArticles()) doReturnConsecutively listOf(cachedArticles, response.articles)

        // THEN
        newsRepository.getNewsArticles().assertItems(
                ViewState.loading(),
                ViewState.success(cachedArticles),
                ViewState.success(response.articles)
        )
    }

    @Test
    fun `get cached news articles when there is no internet`() = runBlocking {
        // GIVEN
        val cachedArticles = listOf(NewsArticles(title = "Cached"))
        val error = RuntimeException("No internet connection")

        // WHEN
        whenever(newsSourceService.getNewsFromGoogle()) doThrow error
        whenever(newsDao.getNewsArticles()) doReturn cachedArticles

        // THEN
        newsRepository.getNewsArticles().assertItems(
                ViewState.loading(),
                ViewState.success(cachedArticles),
                ViewState.error(error.message.orEmpty())
        )
    }
}