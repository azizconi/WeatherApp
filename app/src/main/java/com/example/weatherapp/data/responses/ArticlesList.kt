package com.example.weatherapp.data.responses


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ArticlesList(


    @SerializedName("clouds")
    val clouds: Clouds? = null,
    @SerializedName("dt")
    val dt: Int? = null,
    @SerializedName("dt_txt")

    val dtTxt: String? = null,
    @SerializedName("main")
    var main: Main? = null,
    @SerializedName("pop")
    val pop: Double? = null,
    @SerializedName("rain")
    val rain: Rain? = null,
    @SerializedName("sys")
    val sys: Sys? = null,
    @SerializedName("visibility")
    val visibility: Int? = null,
    @SerializedName("weather")
    val weather: List<Weather>? = null,
    @SerializedName("wind")
    val wind: Wind? = null
): Serializable