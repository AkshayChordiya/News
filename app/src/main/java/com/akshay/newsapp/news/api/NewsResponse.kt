package com.akshay.newsapp.news.api

import com.squareup.moshi.Json

/**
 * Describes the response from news service API.
 */
data class NewsResponse(
    @Json(name = "status")
    val status: String = "",

    @Json(name = "totalResults")
    val totalResults: Int = 0,

    @Json(name = "articles")
    val articles: List<NewsArticle> = emptyList()
)