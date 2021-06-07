package com.example.padi_ku.ui.news.networking

import com.example.capstoneprojectpadiku.news.model.ModelNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("top-headlines")
    fun getHeadlines(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String?
    ): Call<ModelNews>

}