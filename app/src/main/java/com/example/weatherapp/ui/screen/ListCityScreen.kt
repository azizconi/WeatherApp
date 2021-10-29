package com.example.weatherapp.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.MainViewModel


@Composable
fun ListCityScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
) {

    val listCity = listOf("Dushanbe", "Moscow", "Washington", "London")

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {

        listCity.size.let {
            items(1) {
                listCity.forEach { city ->
                    City(city, modifier, viewModel)

                }
            }
        }

    }
}

@Composable
fun City(city: String, modifier: Modifier, viewModel: MainViewModel) {

    val weather = viewModel.weather.observeAsState()

    if (city == weather.value?.city?.name) {
        Column(
            modifier = modifier
                .padding(9.dp)
                .fillMaxWidth()
                .clickable {
                    viewModel.getWeatherList(city = city)
                },
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            Text(
                text = city,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.robotoregular)),
                fontSize = 19.sp
            )
        }
    } else {
        Column(
            modifier = modifier
                .padding(9.dp)
                .fillMaxWidth()
                .clickable {
                    viewModel.getWeatherList(city = city)
                },
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            Text(
                text = city,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.robotoregular)),
                fontSize = 19.sp
            )
        }
    }


}


