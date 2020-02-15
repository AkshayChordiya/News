package com.akshay.newsapp.news.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.newsapp.R
import com.akshay.newsapp.news.ui.adapter.NewsArticlesAdapter
import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.core.ui.base.BaseActivity
import com.akshay.newsapp.news.ui.viewmodel.NewsArticleViewModel
import com.akshay.newsapp.core.utils.getViewModel
import com.akshay.newsapp.core.utils.observeNotNull
import com.akshay.newsapp.core.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*

class NewsActivity : BaseActivity() {

    private val newsArticleViewModel by lazy { getViewModel<NewsArticleViewModel>() }

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up RecyclerView and adapter
        newsList.setEmptyView(empty_view)
        newsList.setProgressView(progress_view)

        val adapter = NewsArticlesAdapter { toast("Clicked on item") }
        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this)

        // Update the UI on state change
        newsArticleViewModel.getNewsArticles().observeNotNull(this) { state ->
            when (state) {
                is ViewState.Success -> adapter.replaceItems(state.data)
                is ViewState.Loading -> newsList.showLoading()
                is ViewState.Error -> toast("Something went wrong ¯\\_(ツ)_/¯ => ${state.message}")
            }
        }

    }
}
