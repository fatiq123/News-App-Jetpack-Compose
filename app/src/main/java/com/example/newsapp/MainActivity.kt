package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.presentation.news_screen.NewsScreen
import com.example.newsapp.presentation.news_screen.viewmodels.NewsScreenViewModel
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                val viewModel: NewsScreenViewModel = hiltViewModel()
                NewsScreen(
                    state = viewModel.state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}
