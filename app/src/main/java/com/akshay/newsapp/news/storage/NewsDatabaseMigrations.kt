package com.akshay.newsapp.news.storage

import androidx.room.migration.Migration

/**
 * Describes migration related to [NewsDatabase].
 */
internal object NewsDatabaseMigration {

    // Bump this on changing the schema
    const val latestVersion = 1

    val allMigrations: Array<Migration>
        get() = arrayOf(
                //// Add migrations here
                // migration_1_2()
        )

    ///**
    // * + describe
    // * + the
    // * + migration
    // * + steps
    // */
    // fun migration_1_2() = object : Migration(1, 2) {
    //    override fun migrate(database: SupportSQLiteDatabase) {
    //        // Add migration code/SQL here, referencing [V1] and [V2] constants
    //    }
    // }

    object V1 {

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
}