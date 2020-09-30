package com.akshay.newsapp.news.api

import com.akshay.newsapp.BuildConfig
import retrofit2.Response
import retrofit2.http.GET

/**
 * Describes endpoints to fetch the news from NewsAPI.
 *
 * Read the documentation [here](https://newsapi.org/docs/v2)
 */
interface NewsService {

    /**
     * Get top headlines.
     *
     * See [article documentation](https://newsapi.org/docs/endpoints/top-headlines).
     */
    @GET("top-headlines?apiKey=${BuildConfig.NEWS_API_KEY}&category=technology")
    suspend fun getTopHeadlines(): Response<NewsResponse>

}
