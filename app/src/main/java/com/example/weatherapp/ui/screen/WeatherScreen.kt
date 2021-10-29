package com.example.weatherapp.ui.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.example.weatherapp.R
import com.example.weatherapp.data.responses.ArticlesList
import com.example.weatherapp.viewModel.MainViewModel
import com.google.accompanist.coil.rememberCoilPainter
import com.example.weatherapp.ui.screen.ListCityScreen as ListCityScreen


@Composable
fun GetWeatherInfo(
    viewModel: MainViewModel,
    mainWeather: ArticlesList
) {


    val weather = viewModel.weather.observeAsState()

    weather.value?.city?.name?.let {
        WeatherInfo(
            city = it,
            articlesList = mainWeather,
            viewModel = viewModel
        )
    }


}


@Composable
fun WeatherInfo(
    modifier: Modifier = Modifier,
    city: String,
    articlesList: ArticlesList,
    viewModel: MainViewModel
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


        WeatherCity(city = city, viewModel = viewModel)
        Temperature(articlesList = articlesList)

        val getDate = articlesList.dtTxt.toString()


        CurrentWeatherDate(date = getDate)

    }


}


@Composable
fun WeatherCity(
    modifier: Modifier = Modifier,
    city: String,
    viewModel: MainViewModel
) {


    var choiceCity by remember {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable {
                choiceCity = !choiceCity
            }
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
    if (choiceCity) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(start = 75.dp, end = 75.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 600,
                        easing = LinearOutSlowInEasing
                    )
                ),
            backgroundColor = Color(0xFF31448B),
        ) {

            ListCityScreen(viewModel = viewModel)

        }
    }

}


@Composable
fun Temperature(
    modifier: Modifier = Modifier,
    articlesList: ArticlesList
) {

    val mainTemp = ((articlesList.main?.temp?.minus(273))?.toInt()).toString()

    val weather = articlesList.weather?.get(0)?.main
    val maxTemp = ((articlesList.main?.tempMax?.minus(273))?.toInt()).toString()
    val minTemp = ((articlesList.main?.tempMin?.minus(273))?.toInt()).toString()



    Column(
        modifier = modifier
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = modifier
                .width(200.dp)
                .padding(start = 10.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = mainTemp,
                fontSize = 80.sp,
                fontFamily = FontFamily(Font(R.font.robotothin)),
                color = Color.White,
                modifier = modifier

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
                    text = weather.toString(),
                    fontFamily = FontFamily(Font(R.font.robotothin)),
                    color = Color.White,
                    fontSize = 22.sp
                )

                Row {
                    Icon(
                        painter = rememberCoilPainter(request = "https://cdn.icon-icons.com/icons2/930/PNG/512/arrow-up_icon-icons.com_72374.png"),
                        contentDescription = "iconWeather",
                        modifier = modifier
                            .size(17.dp)
                            .padding(top = 5.dp),
                        Color.White

                    )

                    Text(
                        text = "$maxTemp℃",
                        fontFamily = FontFamily(Font(R.font.robotothin)),
                        color = Color.White,
                        fontSize = 17.sp
                    )
                }
                Row {
                    Icon(
                        painter = rememberCoilPainter(request = "https://cdn.icon-icons.com/icons2/930/PNG/512/arrow-down_icon-icons.com_72377.png"),
                        contentDescription = "iconWeather",
                        modifier = modifier
                            .size(17.dp)
                            .padding(top = 5.dp),
                        Color.White

                    )


                    Text(
                        text = "$minTemp℃",
                        fontFamily = FontFamily(Font(R.font.robotothin)),
                        color = Color.White,
                        fontSize = 17.sp
                    )
                }


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


