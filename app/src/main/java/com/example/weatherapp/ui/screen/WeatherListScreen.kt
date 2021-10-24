package com.example.weatherapp.ui.screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.coil.rememberCoilPainter




@ExperimentalCoilApi
@Composable
fun LazyListWeather(
    modifier: Modifier = Modifier,
    ) {

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        
        item{
            ItemWeatherList(temperature = "12℃",
                icon = "https://st.depositphotos.com/1007168/1249/i/600/depositphotos_12492734-stock-photo-summer-hot-abstract-sun.jpg",
                timeWeather = "9:00")
        }


    }


}

@ExperimentalCoilApi
@Composable
fun ItemWeatherList(
    modifier: Modifier = Modifier,
    temperature: String,
    icon: String,
    timeWeather: String
) {

    Column(
        modifier = modifier
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = temperature)

        Image(
            painter = rememberCoilPainter(request = icon),
            contentDescription = "iconWeather",
            modifier = modifier
                .size(100.dp)
        )

        Text(text = timeWeather)

    }
}