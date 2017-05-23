package com.akshay.newsapp.ui

import android.arch.lifecycle.LiveData
import com.akshay.newsapp.api.NewsArticleService
import com.akshay.newsapp.api.RestApi
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.NewsSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * The data holder component which observes for data changes and notifies
 * the observers about the data change.
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class NewsArticleLiveData : LiveData<List<NewsArticles>>() {

    /**
     * Init Block to fetch the news and notify the observers about
     * the data change
     */
    init {
        val newsArticleService = RestApi.retrofit.create(NewsArticleService::class.java)
        val newsArticles = newsArticleService.getAllNewsArticles()
        newsArticles.enqueue(object : Callback<NewsSource> {
            override fun onResponse(call: Call<NewsSource>?, response: Response<NewsSource>?) {
                if (response != null) {
                    // Notify observers about data change
                    value = response.body().articles
                }
            }

            override fun onFailure(call: Call<NewsSource>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }
}