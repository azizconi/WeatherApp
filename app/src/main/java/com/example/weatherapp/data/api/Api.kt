package com.example.weatherapp.data.api

import com.example.weatherapp.data.responses.ListWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("data/2.5/forecast")
    fun getListOfHeadLine(
        @Query("id") id: Int = 524901,
        @Query("appid") appid: String = "a29afaa689039c0515ffd15867329caf",
        @Query("q") q: String = "Dushanbe",
    ): Call<ListWeather>

}