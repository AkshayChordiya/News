package com.akshay.newsapp.news.api

import com.akshay.newsapp.BuildConfig
import com.akshay.newsapp.news.model.NewsSourceResponse
import retrofit2.http.GET

/**
 * Fetch all the latest news article from various news services
 * using the News API.
 */
interface NewsService {

    /**
     * Retrieves all the latest news article from Google news using News API.
     */
    @GET("articles?source=google-news&apiKey=${BuildConfig.NEWS_API_KEY}")
    suspend fun getNewsFromGoogle(): NewsSourceResponse

}
