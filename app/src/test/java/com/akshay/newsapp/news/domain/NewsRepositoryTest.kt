package com.akshay.newsapp.news.domain

import com.akshay.newsapp.news.api.NewsService
import com.akshay.newsapp.news.storage.NewsArticlesDao
import com.akshay.newsapp.news.model.NewsArticles
import com.akshay.newsapp.news.model.NewsSourceResponse
import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.core.utils.MockitoTest
import com.akshay.newsapp.core.utils.assertItems
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
    fun `get news articles when there is internet`() = runBlocking {
        // GIVEN
        val cachedArticles = listOf(NewsArticles(title = "Cached"))
        val fetchedArticles = listOf(NewsArticles(title = "Fetched"))
        val newsSource = NewsSourceResponse(articles = fetchedArticles)
        val response = Response.success(newsSource)

        // WHEN
        whenever(newsSourceService.getNewsFromGoogle()) doReturn response
        whenever(newsDao.getNewsArticles()) doReturnConsecutively listOf(flowOf(cachedArticles), flowOf(fetchedArticles))

        // THEN
        newsRepository.getNewsArticles().assertItems(
                ViewState.loading(),
                ViewState.success(cachedArticles),
                ViewState.success(fetchedArticles)
        )
    }

    @Test
    fun `get cached news articles when there is no internet`() = runBlocking {
        // GIVEN
        val cachedArticles = listOf(NewsArticles(title = "Cached"))
        val error = RuntimeException("Unable to fetch from network")

        // WHEN
        whenever(newsSourceService.getNewsFromGoogle()) doThrow error
        whenever(newsDao.getNewsArticles()) doReturn flowOf(cachedArticles)

        // THEN
        newsRepository.getNewsArticles().assertItems(
                ViewState.loading(),
                ViewState.success(cachedArticles),
                ViewState.error(error.message.orEmpty())
        )
    }
}