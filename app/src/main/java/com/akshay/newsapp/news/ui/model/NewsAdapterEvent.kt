package com.akshay.newsapp.news.ui.model

import com.akshay.newsapp.news.storage.entity.NewsArticleDb
import com.akshay.newsapp.news.ui.adapter.NewsArticlesAdapter

/**
 * Describes all the events originated from
 * [NewsArticlesAdapter].
 */
sealed class NewsAdapterEvent {
    /* Describes item click event*/
   data class ClickEvent(val newsArticleDb: NewsArticleDb) : NewsAdapterEvent()
}