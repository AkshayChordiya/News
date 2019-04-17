/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akshay.newsapp.di

import android.app.Application
import android.arch.persistence.room.Room
import com.akshay.newsapp.api.NewsSourceService
import com.akshay.newsapp.db.NewsArticlesDao
import com.akshay.newsapp.db.NewsDatabase
import com.akshay.newsapp.utils.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author tobenna ezike
 * @since 17/4/2019
 */

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideGithubService(): NewsSourceService {
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
