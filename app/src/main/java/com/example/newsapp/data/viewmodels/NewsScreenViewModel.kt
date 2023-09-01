package com.example.newsapp.data.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.data.models.Article
import com.example.newsapp.data.repositories.NewsRepositoryImpl
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsScreenViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
) : ViewModel() {

    var articles by mutableStateOf<List<Article>>(emptyList())

    init {
        getNewsArticles(category = "general")
    }

    private fun getNewsArticles(category: String) {
        viewModelScope.launch {
            val result = newsRepository.getTopHeadlines(category = category)
            when (result) {
                is Resource.Success -> {
                    articles = result.data ?: emptyList()
                }

                is Resource.Error -> TODO()
            }
        }
    }
}