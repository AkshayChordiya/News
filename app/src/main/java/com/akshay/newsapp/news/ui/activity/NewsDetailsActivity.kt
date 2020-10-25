package com.akshay.newsapp.news.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.akshay.newsapp.R
import com.akshay.newsapp.core.ui.ViewState
import com.akshay.newsapp.core.ui.base.BaseActivity
import com.akshay.newsapp.core.ui.compose.NewsTheme
import com.akshay.newsapp.news.storage.entity.NewsArticleDb
import com.akshay.newsapp.news.ui.viewmodel.NewsArticleViewModel
import dev.chrisbanes.accompanist.coil.CoilImage

const val NEWS_ARG_ARTICLE_ID = "articleId"

class NewsDetailsActivity : BaseActivity() {

    private val articleId: Int by lazy {
        intent.getIntExtra(NEWS_ARG_ARTICLE_ID, -1)
    }

    private val newsArticleViewModel: NewsArticleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(topBar = {
                    TopAppBar(
                            title = {},
                            backgroundColor = MaterialTheme.colors.primary,
                            navigationIcon = { IconButton(onClick = { finish() }) {
                                Icon(Icons.Filled.ArrowBack) }
                            }
                    )
                }, bodyContent = {
                        newsDetailsScreen(newsArticleViewModel = newsArticleViewModel, articleId)
                })
            }
        }
    }
}

@Composable
fun newsDetailsScreen(newsArticleViewModel: NewsArticleViewModel, newsId: Int) {
    val viewState: ViewState<NewsArticleDb> by newsArticleViewModel.getNewsArticle(articleId = newsId).observeAsState(ViewState.loading())
    when (viewState) {
        is ViewState.Loading -> {
        }
        is ViewState.Error -> {
        }
        is ViewState.Success -> {
            ScrollableColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
                with((viewState as ViewState.Success<NewsArticleDb>).data) {
                    Spacer(modifier = Modifier.preferredHeight(8.dp))
                    CoilImage(data = urlToImage ?: R.drawable.tools_placeholder,
                            modifier = Modifier
                                    .heightIn(min = 180.dp)
                                    .fillMaxWidth()
                                    .clip(shape = MaterialTheme.shapes.medium)
                    )
                    Spacer(Modifier.preferredHeight(16.dp))
                    Text(text = title ?: "", style = MaterialTheme.typography.h5)
                    Spacer(Modifier.preferredHeight(8.dp))
                    Text(text = content ?: "", style = MaterialTheme.typography.body1)
                }
            }
        }
    }
}
