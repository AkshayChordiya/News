package com.akshay.newsapp.db

import android.arch.persistence.room.Room
import android.content.Context

/**
 * Singleton instance to build the database object only once as
 * it's resource heavy.
 *
 * @author Akshay Chordiya
 * @since 6/5/2017.
 */
object DatabaseCreator {

    /**
     * The database object
     */
    lateinit var database: NewsDatabase

    /**
     * Create database instance when the singleton instance is created for the
     * first time.
     * It overrides the invocation of the object
     */
    operator fun invoke(context: Context): DatabaseCreator {
        database = Room.databaseBuilder(context, NewsDatabase::class.java, "news-db").build()
        return this
    }

}