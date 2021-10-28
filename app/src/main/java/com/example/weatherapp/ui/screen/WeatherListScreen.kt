package com.example.weatherapp.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.weatherapp.Screen
import com.example.weatherapp.data.responses.ArticlesList
import com.google.accompanist.coil.rememberCoilPainter
import java.text.SimpleDateFormat






@ExperimentalCoilApi
@Composable
fun LazyListWeather(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    dataTransmission: (List<ArticlesList>) -> Unit
) {


    val weatherList = viewModel.listOfWeather.observeAsState()

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {


        weatherList.value?.size?.let { it ->

            dataTransmission(mutableListOf(weatherList.value!![0]))

            items(it) {
                val temperature =
                    ((weatherList.value!![it].main!!.temp - 273.15).toInt()).toString()
                var icon = ""

                weatherList.value!![it].weather?.get(0)?.icon.let { it1 ->
                    icon = it1.toString()
                }



                Log.e("TAG", "LazyListWeather: $icon")


                val dateWeather = weatherList.value!![it].dtTxt



                if (weatherList.value!![it] == weatherList.value!![0]) {
                    ItemWeatherList(
                        modifier = modifier
                            .clickable {

                                dataTransmission(mutableListOf(weatherList.value!![it]))

//                                navigateWeather(list)

                            },
                        temperature = "$temperature℃",
                        icon = "https://openweathermap.org/img/wn/$icon@2x.png",
                        timeWeather = "Now",
                    )

                }

                if (weatherList.value!![it] != weatherList.value!![0]) {
                    ItemWeatherList(
                        modifier = modifier
                            .clickable {

                                dataTransmission(mutableListOf(weatherList.value!![it]))

                            },
                        temperature = "$temperature℃",
                        icon = "https://openweathermap.org/img/wn/$icon@2x.png",
                        timeWeather = getDate(dateWeather.toString()),
                    )

                }


            }
        }


    }


}

@ExperimentalCoilApi
@Composable
fun ItemWeatherList(
    modifier: Modifier = Modifier,
    temperature: String,
    icon: String,
    timeWeather: String,
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

@SuppressLint("SimpleDateFormat")
fun getDate(articlesList: String): String {
    val dateWeather = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    val format = "HH:mm"
    val simpleDateFormat = SimpleDateFormat(format)


    return simpleDateFormat.format(dateWeather.parse(articlesList))
}