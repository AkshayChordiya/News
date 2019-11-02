package com.akshay.newsapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshay.newsapp.di.base.ViewModelFactory
import com.akshay.newsapp.di.base.ViewModelKey
import com.akshay.newsapp.ui.viewmodel.NewsArticleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Describes all the [ViewModel] which need to be
 * created using DI.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsArticleViewModel::class)
    abstract fun bindNewsArticleViewModel(newsArticleViewModel: NewsArticleViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
