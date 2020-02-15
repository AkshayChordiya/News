package com.akshay.newsapp.news.di

import android.app.Application
import com.akshay.newsapp.NewsApp
import com.akshay.newsapp.core.di.NewsServiceModule
import com.akshay.newsapp.core.di.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            // Dagger support
            AndroidInjectionModule::class,

            // Global
            NewsDatabaseModule::class,
            NewsServiceModule::class,
            ViewModelFactoryModule::class,

            // News feature
            NewsFeatureBindingModule::class
        ]
)
interface AppComponent : AndroidInjector<NewsApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    override fun inject(newsApp: NewsApp)
}
