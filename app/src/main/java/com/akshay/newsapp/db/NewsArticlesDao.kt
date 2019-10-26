package com.akshay.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.akshay.newsapp.model.NewsArticles

/**
 * Abstracts access to the news database
 */
//TODO: Use inheritance for code re-usability.
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