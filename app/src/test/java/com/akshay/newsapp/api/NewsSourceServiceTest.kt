package com.akshay.newsapp.api

import com.akshay.newsapp.utils.LiveDataCallAdapterFactory
import com.akshay.newsapp.utils.LiveDataTestUtil
import com.akshay.newsapp.utils.create
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 *
 * @author Akshay
 * @since 08/11/2017.
 * @version 1.0
 */
@RunWith(JUnit4::class)
class NewsSourceServiceTest : BaseServiceTest() {

    private lateinit var service: NewsSourceService

    @Before
    @Throws(IOException::class)
    fun createService() {
        service = Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create()
    }

    @Test
    @Throws(IOException::class, InterruptedException::class)
    fun getNewsSource() {
        enqueueResponse("news_source.json")
        val newsSource = LiveDataTestUtil.getValue(service.getNewsSource()).body

        // Dummy request
        mockWebServer.takeRequest()

        // Check news source
        assertThat(newsSource, notNullValue())
        assertThat(newsSource?.source, `is`("google-news"))
        assertThat(newsSource?.sortBy, `is`("top"))
        assertThat(newsSource?.status, `is`("ok"))

        // Check list
        val articles = newsSource?.articles
        assertThat(articles, notNullValue())

        // Check item 1
        val article1 = articles?.get(0)
        assertThat(article1, notNullValue())
        if (article1 != null) {
            assertThat(article1.author, `is`("Akshay"))
            assertThat(article1.title, `is`("Google Pixel 2"))
            assertThat(article1.description, `is`("Gift me Google Pixel 2 ;)"))
        }
    }
}