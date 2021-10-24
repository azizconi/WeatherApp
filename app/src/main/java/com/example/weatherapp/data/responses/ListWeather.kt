package com.example.weatherapp.data.responses


import com.google.gson.annotations.SerializedName

data class ListWeather(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<ArticlesList>,
    @SerializedName("message")
    val message: Int
)