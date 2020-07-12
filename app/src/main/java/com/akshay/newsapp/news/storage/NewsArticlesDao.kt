package com.akshay.newsapp.news.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.akshay.newsapp.news.storage.entity.NewsArticleDb
import kotlinx.coroutines.flow.Flow

/**
 * Defines access layer to news articles table
 */
@Dao
interface NewsArticlesDao {

    /**
     * Insert articles into the table
     */
    @Insert
    fun insertArticles(articles: List<NewsArticleDb>): List<Long>

    @Query("DELETE FROM news_article")
    fun clearAllArticles()

    @Transaction
    fun clearAndCacheArticles(articles: List<NewsArticleDb>) {
        clearAllArticles()
        insertArticles(articles)
    }

    /**
     * Get all the articles from table
     */
    @Query("SELECT * FROM news_article")
    fun getNewsArticles(): Flow<List<NewsArticleDb>>
}