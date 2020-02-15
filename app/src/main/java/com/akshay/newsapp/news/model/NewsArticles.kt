package com.akshay.newsapp.news.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.akshay.newsapp.news.model.NewsArticles.NewsArticles.Column
import com.akshay.newsapp.news.model.NewsArticles.NewsArticles.tableName
import com.google.gson.annotations.SerializedName

/**
 * News Article Model describing the article details
 * fetched from news source.
 *
 * Warning: Ideally network and database model should be different.
 * They are same for this sample app.
 */
@Entity(tableName = tableName)
data class NewsArticles(

        /**
         * Primary key for Room.
         */
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,

        /**
         * Name of the author for the article
         */
        @ColumnInfo(name = Column.author)
        @SerializedName(Column.author)
        val author: String? = null,

        /**
         * Title of the article
         */
        @ColumnInfo(name = Column.title)
        @SerializedName(Column.title)
        val title: String? = null,

        /**
         * Complete description of the article
         */
        @ColumnInfo(name = Column.description)
        @SerializedName(Column.description)
        val description: String? = null,

        /**
         * URL to the article
         */
        @ColumnInfo(name = Column.url)
        @SerializedName(Column.url)
        val url: String? = null,

        /**
         * URL of the artwork shown with article
         */
        @ColumnInfo(name = Column.urlToImage)
        @SerializedName(Column.urlToImage)
        val urlToImage: String? = null,

        /**
         * Date-time when the article was published
         */
        @ColumnInfo(name = Column.publishedAt)
        @SerializedName(Column.publishedAt)
        val publishedAt: String? = null
) {
    object NewsArticles {
        const val tableName = "news_article"

        object Column {
            const val id = "id"
            const val author = "author"
            const val title = "title"
            const val description = "description"
            const val url = "url"
            const val urlToImage = "urlToImage"
            const val publishedAt = "publishedAt"
        }
    }
}