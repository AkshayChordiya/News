package com.akshay.newsapp.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akshay.newsapp.R
import com.akshay.newsapp.model.NewsArticles
import com.akshay.newsapp.utils.inflate
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.row_news_article.view.*

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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsHolder(parent.inflate(R.layout.row_news_article))

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
    class NewsHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: NewsArticles, listener: (NewsArticles) -> Unit) = with(itemView) {
            //news_title.text = newsArticle.title
            //news_description.text = newsArticle.description
            tvNewsItemTitle.text = newsArticle.title
            tvNewsAuthor.text = newsArticle.author
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)
            tvListItemDateTime.text = newsArticle.publishedAt
            Glide.with(context)
                    .load(newsArticle.urlToImage)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.img_test_one)
                            .error(R.drawable.img_test_one)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(ivNewsImage)
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