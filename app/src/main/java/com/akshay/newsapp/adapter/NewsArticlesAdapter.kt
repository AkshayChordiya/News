package com.akshay.newsapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.akshay.newsapp.R
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.utils.inflate
import kotlinx.android.synthetic.main.news_article_item.view.*

/**
 * The News adapter to show the news in a list.
 *
 * @author Akshay Chordiya
 * @since 5/23/2017.
 */
class NewsArticlesAdapter(
        private val listener: (NewsArticles) -> Unit
) : RecyclerView.Adapter<NewsArticlesAdapter.NewsHolder>() {

    /**
     * List of news articles
     */
    private var newsArticles: List<NewsArticles> = emptyList()

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsHolder(parent.inflate(R.layout.news_article_item))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) = newsHolder.bind(newsArticles[position], listener)

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = newsArticles.size

    /**
     * View Holder Pattern
     */
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: NewsArticles, listener: (NewsArticles) -> Unit) = with(itemView) {
            news_title.text = newsArticle.title
            news_description.text = newsArticle.description
            setOnClickListener { listener(newsArticle) }
        }
    }

    /**
     * Swap function to set new data on updating
     */
    fun replaceItems(items: List<NewsArticles>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}