package com.example.newsapp.presentation.news_screen.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.news_screen.NewsScreenEvent
import com.example.newsapp.presentation.news_screen.NewsScreenState
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsScreenViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
) : ViewModel() {

    var articles by mutableStateOf<List<Article>>(emptyList())

    var state by mutableStateOf(NewsScreenState())

    fun onEvent(event: NewsScreenEvent) {
        when (event) {
            is NewsScreenEvent.OnCategoryChanged -> {
                state = state.copy(category = event.category)
                getNewsArticles(category = state.category)
            }

            NewsScreenEvent.OnCloseIconClicked -> TODO()
            is NewsScreenEvent.OnNewsCardClicked -> TODO()
            NewsScreenEvent.OnSearchIconClicked -> TODO()
            is NewsScreenEvent.OnSearchQueryChanged -> TODO()
        }
    }

    init {
        getNewsArticles(category = "general")
    }

    private fun getNewsArticles(category: String) {
        viewModelScope.launch {
            state = state.copy(isLoading = false)
            val result = newsRepository.getTopHeadlines(category = category)
            when (result) {
                is Resource.Success -> {
                    state = state.copy(
                        articles = result.data ?: emptyList(),
                        isLoading = true
                    )
                }

                is Resource.Error -> TODO()
            }
        }
    }
}