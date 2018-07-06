package com.akshay.newsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akshay.newsapp.model.NewsArticles

/**
 *
 * @author Akshay Chordiya
 * @since 6/5/2017.
 */
@Database(entities = arrayOf(NewsArticles::class), version = 1)
abstract class NewsDatabase : RoomDatabase() {

    /**
     * Get news article DAO
     */
    abstract fun newsArticlesDao(): NewsArticlesDao
}