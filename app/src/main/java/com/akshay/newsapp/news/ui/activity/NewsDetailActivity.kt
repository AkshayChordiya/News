package com.akshay.newsapp.news.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import coil.api.load
import com.akshay.newsapp.R
import com.akshay.newsapp.news.model.NewsArticles
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val image = intent.getParcelableExtra<NewsArticles>("details")

        newsImage.load(image?.urlToImage) {
            placeholder(R.drawable.tools_placeholder)
            error(R.drawable.tools_placeholder)
        }

        newsTitle.text = image?.title

        newsDescription.text = image?.description
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
