package com.example.newsapp.data

interface NewsRepository {

    suspend fun getTopHeadlines(category: String)

}