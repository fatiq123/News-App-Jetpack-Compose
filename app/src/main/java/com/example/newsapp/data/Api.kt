package com.example.newsapp.data

import com.example.newsapp.utils.Constants
import com.example.newsapp.data.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = Constants.API_KEY,
    ) : NewsResponse

}