package com.akshay.newsapp.news.api

import com.squareup.moshi.Json

data class NewsArticle(
    @Json(name = "source")
    val source: Source,

    /**
     * Name of the author for the article
     */
    @Json(name = "author")
    val author: String? = null,

    /**
     * Title of the article
     */
    @Json(name = "title")
    val title: String? = null,

    /**
     * Complete description of the article
     */
    @Json(name = "description")
    val description: String? = null,

    /**
     * URL to the article
     */
    @Json(name = "url")
    val url: String? = null,

    /**
     * URL of the artwork shown with article
     */
    @Json(name = "urlToImage")
    val urlToImage: String? = null,

    /**
     * Date-time when the article was published
     */
    @Json(name = "publishedAt")
    val publishedAt: String? = null,

    @Json(name = "content")
    val content: String? = null
) {
    data class Source(

        @Json(name = "id")
        val id: String? = null,

        @Json(name = "name")
        val name: String? = null
    )
}