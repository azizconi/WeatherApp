package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import coil.annotation.ExperimentalCoilApi
import com.example.weatherapp.data.responses.ArticlesList
import com.example.weatherapp.data.responses.ListWeather
import com.example.weatherapp.ui.screen.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()



    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getWeatherList()


//        viewModel.weather.observe(this, {
//            setData(it)
//        })


        setContent {


            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    GetWeatherInfo(viewModel)
//                    WeatherInfo()
                    LazyListWeather(
                        modifier = Modifier,
                        viewModel = viewModel,
                    )
                }
            }


        }
    }


    @SuppressLint("SimpleDateFormat")
    fun getDate(articlesList: ArticlesList): String {
        val date: Date = Date()
        val format = "HH:mm"
        val simpleDateFormat = SimpleDateFormat(format)

        return simpleDateFormat.format(date)
    }


}










