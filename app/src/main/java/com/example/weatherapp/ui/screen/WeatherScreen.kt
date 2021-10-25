package com.example.weatherapp.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.R
import com.example.weatherapp.data.responses.ArticlesList
import com.example.weatherapp.data.responses.ListWeather


var listOfWeather: List<ArticlesList> = emptyList()


fun setData(list: List<ArticlesList>){
    listOfWeather = list


}







@Composable
fun GetWeatherInfo(
    viewModel: MainViewModel
) {


    Log.e("TAG", "GetWeatherInfo: $listOfWeather", )

    val weather = viewModel.weather.observeAsState()
    Log.e("TAG", "GetWeatherInfo: ${weather.value?.city?.name}", )

    weather.value?.city?.name?.let { WeatherInfo(city = it) }
}



@Composable
fun WeatherInfo(
    modifier: Modifier = Modifier,
    city: String,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(525.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xff7187d8),
                        Color(0xff7187dc),
                        Color(0xff7288dd),
                        Color(0xff6f87dc),
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {


        WeatherCity(city = city)
        Temperature()
        CurrentWeatherDate(date = "21.12.2021")
    }


}








@Composable
fun WeatherCity(
    modifier: Modifier = Modifier,
    city:String
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

            Text(
                text = city,
                fontSize = 19.sp,
                modifier = modifier
                    .padding(top = 30.dp),
                fontFamily = FontFamily(Font(R.font.robotolight)),
                color = Color.White,
            )


        Icon(
            painter = painterResource(id = R.drawable.kebab),
            contentDescription = "cities",
            Modifier
                .height(24.dp)
                .width(24.dp),
            Color.White
        )
    }

}


@Composable
fun Temperature(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 50.dp)
    ) {

        Row(
            modifier = modifier
                .width(200.dp)
                .padding(start = 10.dp),
            verticalAlignment = Alignment.Bottom,
        ) {

            Text(
                text = "19",
                fontSize = 80.sp,
                fontFamily = FontFamily(Font(R.font.robotothin)),
                color = Color.White
            )

            Column(modifier = modifier.height(90.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.gradus1),
                    contentDescription = "cities",
                    Modifier
                        .height(16.dp)
                        .width(16.dp),
                    Color.White
                )
            }



            Column(
                modifier = modifier
                    .width(100.dp)
                    .height(90.dp)
                    .padding(start = 7.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Rain",
                    fontFamily = FontFamily(Font(R.font.robotothin)),
                    color = Color.White,
                    fontSize = 22.sp
                )

                Text(
                    text = "27℃",
                    fontFamily = FontFamily(Font(R.font.robotothin)),
                    color = Color.White,
                    fontSize = 17.sp
                )

                Text(
                    text = "10℃",
                    fontFamily = FontFamily(Font(R.font.robotothin)),
                    color = Color.White,
                    fontSize = 17.sp
                )
            }
        }
    }
}


@Composable
fun CurrentWeatherDate(
    modifier: Modifier = Modifier,
    date: String
) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = date,
            fontSize = 17.sp,
            fontFamily = FontFamily(Font(R.font.robotoregular)),
            color = Color.White
        )

    }


}


