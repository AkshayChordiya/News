package com.akshay.newsapp.db

import android.content.Context
import androidx.room.Room

/**
 * Singleton instance to build the database object only once as
 * it's resource heavy.
 *
 * @author Akshay Chordiya
 * @since 6/5/2017.
 */
object DatabaseCreator {

    /**
     * Create database instance when the singleton instance is created for the
     * first time.
     */
    fun database(context: Context): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, "news-db").build()
    }

}