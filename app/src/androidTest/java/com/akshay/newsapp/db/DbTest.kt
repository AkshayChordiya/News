package com.akshay.newsapp.db

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import org.junit.After
import org.junit.Before


/**
 *
 * @author Akshay Chordiya
 * @since 08/11/2017.
 * @version 1.0
 */
abstract class DbTest {

    protected lateinit var db: NewsDatabase

    @Before
    fun initDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                NewsDatabase::class.java).build()
    }

    @After
    fun closeDb() = db.close()
}