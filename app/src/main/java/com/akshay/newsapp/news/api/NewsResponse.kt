package com.akshay.newsapp.news.api

import com.google.gson.annotations.SerializedName

/**
 * Describes the response from news service API.
 */
data class NewsResponse(
        @SerializedName("status")
        val status: String = "",

        @SerializedName("source")
        val source: String = "",

        @SerializedName("sortBy")
        val sortBy: String = "",

        @SerializedName("articles")
        val articles: List<NewsArticle> = emptyList()
)