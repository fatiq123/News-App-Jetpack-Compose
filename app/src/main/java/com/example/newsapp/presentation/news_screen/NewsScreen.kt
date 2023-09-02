package com.example.newsapp.presentation.news_screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.component.CategoryTabRow
import com.example.newsapp.presentation.component.NewsArticleCard
import com.example.newsapp.presentation.component.NewsScreenTopAppBar
import com.example.newsapp.presentation.component.RetryContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun NewsScreen(
    state: NewsScreenState,
    onEvent: (NewsScreenEvent) -> Unit,
) {
    /*val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Log.d("Response","${viewModel.articles}")
        Text(text = "" + viewModel.articles, style = MaterialTheme.typography.bodyMedium)

    }*/
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val coroutineScope = rememberCoroutineScope()
    val categories = listOf(
        "General", "Business", "Health", "Science", "Sports", "Technology", "Entertainment"
    )
    val pagerState = rememberPagerState(pageCount = {
        categories.size
    })



    LaunchedEffect(key1 = pagerState) {
        snapshotFlow {
            pagerState.currentPage
        }.collect { page ->
            onEvent(NewsScreenEvent.OnCategoryChanged(category = categories[page]))
        }
    }


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            NewsScreenTopAppBar(
                scrollBehavior = scrollBehavior,
                onSearchIconClicked = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            CategoryTabRow(
                pagerSate = pagerState,
                categories = categories,
                onTabSelected = { index ->
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
            HorizontalPager(
                state = pagerState      /*note here we cannot provide pageCount as we already have set pageCount in pagerState*/
            ) {
                NewsArticleList(
                    state = state,
                    onCardClicked = {},
                    onRetry = {
                        onEvent(NewsScreenEvent.OnCategoryChanged(state.category))
                    },
                )
            }

        }

    }

}


@Composable
fun NewsArticleList(
    state: NewsScreenState,
    onCardClicked: (Article) -> Unit,
    onRetry: () -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        /*modifier = Modifier.padding(paddingValues = paddingValues)*/
    ) {
        items(state.articles) { article ->
            Log.d("Response", "$article")
            NewsArticleCard(
                article = article,
                onCardClicked = onCardClicked
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        if (state.error != null) {
            RetryContent(
                error = state.error,
                onRetry = onRetry
            )
        }
    }
}
// 38.50
// state: Any value that can change during the usage of app
// event: All the possible actions a user can do