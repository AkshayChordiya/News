package com.akshay.newsapp.news.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.akshay.newsapp.news.storage.entity.NewsArticleDb.NewsArticles.Column
import com.akshay.newsapp.news.storage.entity.NewsArticleDb.NewsArticles.tableName

/**
 * Describes how the news article are stored.
 */
@Entity(tableName = tableName)
data class NewsArticleDb(

        /**
         * Primary key for Room.
         */
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,

        /**
         * Name of the author for the article
         */
        @ColumnInfo(name = Column.author)
        val author: String? = null,

        /**
         * Title of the article
         */
        @ColumnInfo(name = Column.title)
        val title: String? = null,

        /**
         * Complete description of the article
         */
        @ColumnInfo(name = Column.description)
        val description: String? = null,

        /**
         * URL to the article
         */
        @ColumnInfo(name = Column.url)
        val url: String? = null,

        /**
         * URL of the artwork shown with article
         */
        @ColumnInfo(name = Column.urlToImage)
        val urlToImage: String? = null,

        /**
         * Date-time when the article was published
         */
        @ColumnInfo(name = Column.publishedAt)
        val publishedAt: String? = null,

        @Embedded(prefix = "source_")
        val source: Source,

        @ColumnInfo(name = Column.content)
        val content: String? = null
) {

    data class Source(
        @ColumnInfo(name = Column.sourceId)
        val id: String? = null,

        @ColumnInfo(name = Column.sourceName)
        val name: String? = null
    )

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
            const val content = "content"

            const val sourceId = "id"
            const val sourceName = "name"
        }
    }
}