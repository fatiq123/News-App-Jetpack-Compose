package com.example.newsapp.di

import com.example.newsapp.data.Api
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.data.repositories.NewsRepositoryImpl
import com.example.newsapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNewsApi(): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: Api): NewsRepository {
        return NewsRepositoryImpl(api)
    }
}