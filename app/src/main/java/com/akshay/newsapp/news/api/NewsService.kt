package com.akshay.newsapp.news.api

import com.akshay.newsapp.BuildConfig
import retrofit2.Response
import retrofit2.http.GET

/**
 * Describes endpoints to fetch the news from NewsAPI.
 *
 * Read the documentation [here](https://newsapi.org/docs/v1)
 */
interface NewsService {

    /**
     * Retrieves all the latest news article from Google news using News API.
     *
     * See [article documentation](https://newsapi.org/docs/v1#apiArticles).
     */
    @GET("articles?source=the-verge&apiKey=${BuildConfig.NEWS_API_KEY}")
    suspend fun getNewsFromGoogle(): Response<NewsResponse>

}
