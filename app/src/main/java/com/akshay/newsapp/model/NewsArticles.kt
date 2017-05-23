package com.akshay.newsapp.model

import com.google.gson.annotations.SerializedName

/**
 * Model describing the news article details fetched from
 * Google News.
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class NewsArticles(
        @SerializedName("author") var author: String = "",
        @SerializedName("title") var title: String = "",
        @SerializedName("description") var description: String = "",
        @SerializedName("url") var url: String = "",
        @SerializedName("urlToImage") var urlToImage: String = "",
        @SerializedName("publishedAt") var publishedAt: String = "") {
}