package com.akshay.newsapp.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.newsapp.R
import com.akshay.newsapp.adapter.NewsArticlesAdapter
import com.akshay.newsapp.ui.NewsArticleViewModel
import com.akshay.newsapp.ui.base.BaseActivity
import com.akshay.newsapp.utils.getViewModel
import com.akshay.newsapp.utils.load
import com.akshay.newsapp.utils.observe
import com.akshay.newsapp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*

/**
 * The Main or Starting Activity.
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class MainActivity : BaseActivity() {

    private val newsArticleViewModel by lazy { getViewModel<NewsArticleViewModel>() }

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up RecyclerView and adapter
        news_list.setEmptyView(empty_view)
        news_list.setProgressView(progress_view)

        val adapter = NewsArticlesAdapter {
            toast("Clicked on item")
        }
        news_list.adapter = adapter
        news_list.layoutManager = LinearLayoutManager(this)

        // Observing for data change
        newsArticleViewModel.getNewsArticles().observe(this) {
            it.load(news_list) {
                // Update the UI as the data has changed
                it?.let { adapter.replaceItems(it) }
            }
        }

    }
}
