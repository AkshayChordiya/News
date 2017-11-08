package com.akshay.newsapp.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.akshay.newsapp.R
import com.akshay.newsapp.adapter.NewsArticlesAdapter
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.model.Resource
import com.akshay.newsapp.ui.NewsArticleViewModel
import com.akshay.newsapp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The Main or Starting Activity.
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the ViewModel component
        val newsArticleViewModel = ViewModelProviders.of(this).get(NewsArticleViewModel::class.java)

        // Setting up RecyclerView and adapter
        val adapter = NewsArticlesAdapter {
            toast("Clicked on item")
        }
        news_list.adapter = adapter
        news_list.layoutManager = LinearLayoutManager(this)

        // Observing for data change
        newsArticleViewModel.getNewsArticles().observe(this, Observer<Resource<List<NewsArticles>>> {
            Log.d("Main", "Res = $it")
            Log.d("Main", "Data = ${it?.data}")
            it?.data?.apply {
                // Update the UI as the data has changed
                adapter.replaceItems(this)
                adapter.notifyDataSetChanged()
            }
        })

    }
}
