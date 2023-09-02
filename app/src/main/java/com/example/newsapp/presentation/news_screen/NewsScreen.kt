package com.example.newsapp.presentation.news_screen

import android.util.Log
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.data.viewmodels.NewsScreenViewModel
import com.example.newsapp.presentation.component.NewsArticleCard

@Composable
fun NewsScreen(
    viewModel: NewsScreenViewModel = hiltViewModel(),
) {
    /*val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Log.d("Response","${viewModel.articles}")
        Text(text = "" + viewModel.articles, style = MaterialTheme.typography.bodyMedium)

    }*/
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(viewModel.articles) { article ->
            Log.d("Response","$article")
            NewsArticleCard(article = article, onCardClicked = {})
        }
    }
}
// 38.50