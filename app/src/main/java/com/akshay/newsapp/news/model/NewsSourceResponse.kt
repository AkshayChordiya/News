package com.akshay.newsapp.news.model

import com.google.gson.annotations.SerializedName

/**
 * News source model describing the source details
 * and the articles under it.
 */
data class NewsSourceResponse(
        @SerializedName("status")
        val status: String = "",

        @SerializedName("source")
        val source: String = "",

        @SerializedName("sortBy")
        val sortBy: String = "",

        @SerializedName("articles")
        val articles: List<NewsArticles> = emptyList()
)