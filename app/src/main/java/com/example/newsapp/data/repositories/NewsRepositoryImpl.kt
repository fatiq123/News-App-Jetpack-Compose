package com.example.newsapp.data.repositories

import com.example.newsapp.data.Api
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.data.models.Article
import com.example.newsapp.utils.Resource

class NewsRepositoryImpl(
    private val newsApi: Api,
) : NewsRepository {
    override suspend fun getTopHeadlines(category: String): Resource<List<Article>> {
        return try {
            val response = newsApi.getBreakingNews(category = category)
            Resource.Success(response.articles)
        } catch (e: Exception) {
            Resource.Error(message = "Failed to fetch news ${e.message}")
        }
    }

}