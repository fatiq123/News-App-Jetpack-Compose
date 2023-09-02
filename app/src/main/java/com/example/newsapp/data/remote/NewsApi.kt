package com.example.newsapp.data.remote

import com.example.newsapp.utils.Constants
import com.example.newsapp.domain.model.NewsResponse
import com.example.newsapp.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse


}