package com.akshay.newsapp.db

import androidx.test.runner.AndroidJUnit4
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.utils.LiveDataTestUtil
import com.akshay.newsapp.utils.TestDataUtils
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 *
 * @author Akshay Chordiya
 * @since 08/11/2017.
 * @version 1.0
 */
@RunWith(AndroidJUnit4::class)
class NewsArticlesDaoTest : DbTest() {

    @Test
    @Throws(InterruptedException::class)
    fun insertNewsArticles() {
        val articles = TestDataUtils.createNewsArticles(NewsArticles(1), NewsArticles(2))
        assertThat(db.newsArticlesDao().insertArticles(articles), `is`(listOf(1L, 2L)))
    }

    @Test
    @Throws(InterruptedException::class)
    fun insertNewsArticlesAndRead() {
        val feeds = TestDataUtils.createNewsArticles(
                NewsArticles(1, "First", "Hello"),
                NewsArticles(2, "Second", "Testing")
        )
        db.newsArticlesDao().insertArticles(feeds)
        val loaded = LiveDataTestUtil.getValue(db.newsArticlesDao().getNewsArticles())
        assertThat(loaded.size, `is`(2))

        // 1st
        val first = loaded[0]
        assertThat(first.author, `is`("First"))
        assertThat(first.title, `is`("Hello"))

        // 2nd
        val second = loaded[1]
        assertThat(second.author, `is`("Second"))
        assertThat(second.title, `is`("Testing"))
    }

}