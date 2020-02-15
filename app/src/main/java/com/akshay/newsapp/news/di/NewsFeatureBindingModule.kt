package com.akshay.newsapp.news.di

import com.akshay.newsapp.news.domain.NewsRepositoryModule
import com.akshay.newsapp.news.ui.activity.NewsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Describes list of activities which require
 * DI.
 *
 * Each [ContributesAndroidInjector] generates a sub-component
 * for each activity under the hood
 */
@Module(includes = [
    NewsViewModelModule::class,
    NewsRepositoryModule::class
])
interface NewsFeatureBindingModule {

    @ContributesAndroidInjector
    fun contributeNewsActivity(): NewsActivity
}