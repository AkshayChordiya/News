package com.akshay.newsapp.di

import android.app.Application
import com.akshay.newsapp.db.NewsArticlesDao
import com.akshay.newsapp.db.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NewsDatabaseModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): NewsDatabase = NewsDatabase.buildDefault(app)

    @Singleton
    @Provides
    fun provideUserDao(db: NewsDatabase): NewsArticlesDao = db.newsArticlesDao()
}