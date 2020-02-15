package com.akshay.newsapp.news.di

import android.app.Application
import com.akshay.newsapp.NewsApp
import com.akshay.newsapp.core.di.NewsServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            // Dagger support
            AndroidInjectionModule::class,

            // App
            NewsDatabaseModule::class,
            NewsServiceModule::class,
            NewsActivityBindingModule::class,
            ViewModelModule::class
        ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(newsApp: NewsApp)
}
