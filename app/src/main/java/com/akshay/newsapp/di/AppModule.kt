package com.akshay.newsapp.di

import android.app.Application
import androidx.room.Room
import com.akshay.newsapp.api.NewsSourceService
import com.akshay.newsapp.db.NewsArticlesDao
import com.akshay.newsapp.db.NewsDatabase
import com.akshay.newsapp.utils.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideNewsService(): NewsSourceService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(NewsSourceService::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): NewsDatabase {
        return Room.databaseBuilder(app, NewsDatabase::class.java, "news-db").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: NewsDatabase): NewsArticlesDao {
        return db.newsArticlesDao()
    }

    companion object {
        private const val BASE_URL = "https://newsapi.org/v1/"
    }
}
