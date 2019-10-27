package com.akshay.newsapp.api

import com.akshay.newsapp.BuildConfig
import com.akshay.newsapp.model.NewsSource
import retrofit2.http.GET

/**
 * Fetch all the latest news article from Google news.
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
interface NewsSourceService {

    /**
     * Retrieves all the latest news article from Google news.
     */
    @GET("articles?source=google-news&apiKey=" + BuildConfig.NEWS_API_KEY)
    suspend fun getNewsSource(): NewsSource

}
