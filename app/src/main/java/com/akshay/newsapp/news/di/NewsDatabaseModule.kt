package com.akshay.newsapp.news.di

import android.app.Application
import com.akshay.newsapp.news.storage.NewsArticlesDao
import com.akshay.newsapp.news.storage.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NewsDatabaseModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): NewsDatabase = NewsDatabase.buildDefault(app)

    @Singleton
    @Provides
    fun provideUserDao(db: NewsDatabase): NewsArticlesDao = db.newsArticlesDao()
}