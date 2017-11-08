package com.akshay.newsapp.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.akshay.newsapp.model.NewsArticles

/**
 * Abstracts access to the news database
 */
@Dao
interface NewsArticlesDao {

    /**
     * Insert articles into the database
     */
    @Insert
    fun insertArticles(articles: List<NewsArticles>): List<Long>

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM news_article")
    fun getNewsArticles(): LiveData<List<NewsArticles>>
}