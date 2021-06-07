package com.example.capstoneprojectpadiku.news.model

import com.google.gson.annotations.SerializedName

data class ModelNews(
    @SerializedName("status")
    val status: String = "",

    @SerializedName("totalResults")
    val totalResults: Int = 0,

    @SerializedName("articles")
    val newsModel: List<NewsModel> = emptyList()
)