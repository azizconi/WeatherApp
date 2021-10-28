package com.example.weatherapp

import com.example.weatherapp.data.responses.ArticlesList

sealed class Screen(val route: String) {
    object MainWeatherScreen : Screen("main_screen")
    object ListWeatherScreen : Screen("list_screen")


    @ExperimentalStdlibApi
    fun withArgs(
        vararg lists: List<ArticlesList>
    ): List<ArticlesList> {
        return buildList<ArticlesList> {
            lists.forEach { list ->

            }
        }
    }


}
