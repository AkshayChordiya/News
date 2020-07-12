package com.akshay.newsapp.news.api

import com.google.gson.annotations.SerializedName

data class NewsArticle(
        /**
         * Name of the author for the article
         */
        @SerializedName("author")
        val author: String? = null,

        /**
         * Title of the article
         */
        @SerializedName("title")
        val title: String? = null,

        /**
         * Complete description of the article
         */
        @SerializedName("description")
        val description: String? = null,

        /**
         * URL to the article
         */
        @SerializedName("url")
        val url: String? = null,

        /**
         * URL of the artwork shown with article
         */
        @SerializedName("urlToImage")
        val urlToImage: String? = null,

        /**
         * Date-time when the article was published
         */
        @SerializedName("publishedAt")
        val publishedAt: String? = null
)