package com.akshay.newsapp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.akshay.newsapp.R
import com.akshay.newsapp.adapter.NewsArticlesAdapter
import com.akshay.newsapp.ui.NewsArticleViewModel
import com.akshay.newsapp.utils.getViewModel
import com.akshay.newsapp.utils.observe
import com.akshay.newsapp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The Main or Starting Activity.
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class MainActivity : AppCompatActivity() {

    private val newsArticleViewModel by lazy { getViewModel<NewsArticleViewModel>() }

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up RecyclerView and adapter
        val adapter = NewsArticlesAdapter {
            toast("Clicked on item")
        }
        news_list.adapter = adapter
        news_list.layoutManager = LinearLayoutManager(this)

        // Observing for data change
        newsArticleViewModel.getNewsArticles().observe(this) {
            it.data?.apply {
                //TODO: Show loading or empty state with RecyclerView
                // Update the UI as the data has changed
                adapter.replaceItems(this)
            }
        }

    }
}
