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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import coil.annotation.ExperimentalCoilApi
import com.example.weatherapp.data.responses.ArticlesList
import com.example.weatherapp.ui.screen.GetWeatherInfo
import com.example.weatherapp.ui.screen.LazyListWeather
import com.example.weatherapp.ui.screen.MainViewModel
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var list: LiveData<List<ArticlesList>>



    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getWeatherList()


        setContent {











            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {


                Column {


                    GetWeatherInfo(viewModel)

                    LazyListWeather(
                        modifier = Modifier,
                        viewModel = viewModel
                    ){
                        list = it
                    }





                }
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













