package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.example.weatherapp.data.responses.ArticlesList
import com.example.weatherapp.ui.screen.GetWeatherInfo
import com.example.weatherapp.ui.screen.LazyListWeather
import com.example.weatherapp.viewModel.MainViewModel


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()


    @SuppressLint("RememberReturnType")
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getWeatherList(city = "Dushanbe")





        setContent {


            val list = remember {
                mutableStateOf(ArticlesList())
            }



            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {


                Column {


                    GetWeatherInfo(viewModel, list.value)

                    LazyListWeather(
                        modifier = Modifier,
                        viewModel = viewModel,

                        ) {
                        list.value = it
                    }


                }
            }


        }


    }
}












