package com.akshay.newsapp.utils

import com.akshay.newsapp.model.NewsArticles

/**
 * @author Akshay Chordiya
 * @version 1.0
 * @since 08/11/2017.
 */

object TestDataUtils {

    fun createNewsArticles(vararg newsArticles: NewsArticles): List<NewsArticles> {
        return newsArticles.toList()
    }
}
