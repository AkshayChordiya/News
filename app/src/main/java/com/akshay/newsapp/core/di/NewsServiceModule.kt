package com.akshay.newsapp.core.di

import com.akshay.newsapp.news.api.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NewsServiceModule {

    @Singleton
    @Provides
    fun provideNewsService(): NewsService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsService::class.java)
    }

    companion object {
        private const val BASE_URL = "https://newsapi.org/v1/"
    }
}