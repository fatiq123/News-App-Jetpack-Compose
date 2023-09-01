package com.example.newsapp.data

import com.example.newsapp.data.models.Article
import com.example.newsapp.utils.Resource

interface NewsRepository {

    suspend fun getTopHeadlines(category: String): Resource<List<Article>>

}