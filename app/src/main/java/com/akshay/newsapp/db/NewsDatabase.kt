package com.akshay.newsapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.akshay.newsapp.model.NewsArticles

/**
 *
 * @author Akshay Chordiya
 * @since 6/5/2017.
 */
@Database(entities = [NewsArticles::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {

    /**
     * Get news article DAO
     */
    abstract fun newsArticlesDao(): NewsArticlesDao
}