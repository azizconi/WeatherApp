package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import coil.annotation.ExperimentalCoilApi
import com.example.weatherapp.data.responses.ListWeather
import com.example.weatherapp.ui.screen.*


class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel


    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
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

                    WeatherInfo(list = "")
                    LazyListWeather(
                        modifier = Modifier,
                    )
                }
            }


        }
    }
}







