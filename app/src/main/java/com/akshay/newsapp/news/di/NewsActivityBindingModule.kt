package com.akshay.newsapp.news.di

import com.akshay.newsapp.news.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Describes list of activities which require
 * DI.
 */
@Module
abstract class NewsActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
