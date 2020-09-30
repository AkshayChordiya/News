package com.akshay.newsapp.news.storage

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Describes migration related to [NewsDatabase].
 */
internal object NewsDatabaseMigration {

    // Bump this on changing the schema
    const val latestVersion = 2

    val allMigrations: Array<Migration>
        get() = arrayOf(
            //// Add migrations here
            migration_1_2()
        )

    ///**
    // * + describe
    // * + the
    // * + migration
    // * + steps
    // */
    private fun migration_1_2() = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Add migration code/SQL here, referencing [V1] and [V2] constants
            database.execSQL("ALTER TABLE ${V2.NewsArticle.tableName} ADD COLUMN ${V2.NewsArticle.Column.content} TEXT DEFAULT NULL")
            database.execSQL("ALTER TABLE ${V2.NewsArticle.tableName} ADD COLUMN ${V2.NewsArticle.Column.sourceId} TEXT DEFAULT NULL")
            database.execSQL("ALTER TABLE ${V2.NewsArticle.tableName} ADD COLUMN ${V2.NewsArticle.Column.sourceName} TEXT DEFAULT \"\"")
        }
    }

    object V2 {

        object NewsArticle {
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
                const val sourceId = "source_id"
                const val sourceName = "source_name"
            }
        }
    }

    object V1 {

        object NewsArticle {
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
}