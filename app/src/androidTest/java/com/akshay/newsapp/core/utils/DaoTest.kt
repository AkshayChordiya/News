package com.akshay.newsapp.core.utils

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before

/**
 * Base class to reduce boilerplate code for testing DAO(s) of [RoomDatabase].
 */
abstract class DaoTest<Database: RoomDatabase>(
        private val database: Class<Database>
): MockitoTest() {

    protected lateinit var db: Database

    @Before
    override fun setup() {
        super.setup()
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext<Context>(), database).build()
    }

    @After
    fun teardown() = db.close()
}