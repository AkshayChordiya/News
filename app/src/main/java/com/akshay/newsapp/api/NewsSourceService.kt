package com.akshay.newsapp.api

import androidx.lifecycle.LiveData
import com.akshay.newsapp.BuildConfig
import com.akshay.newsapp.model.NewsSource
import com.akshay.newsapp.model.network.Resource
import com.akshay.newsapp.utils.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    fun getNewsSource(): LiveData<Resource<NewsSource>>

    /**
     * Kinda like a static block in Java
     */
    companion object Factory {
        private const val BASE_URL = "https://newsapi.org/v1/"

        // TODO: Move to DI.
        fun getNewsSourceService(): NewsSourceService {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .build()
                    .create(NewsSourceService::class.java)
        }
    }
}
