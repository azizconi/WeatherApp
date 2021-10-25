package com.example.weatherapp.ui.screen


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.api.RetrofitInstance
import com.example.weatherapp.data.responses.ArticlesList
import com.example.weatherapp.data.responses.ListWeather
import com.example.weatherapp.data.responses.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(application: Application) : AndroidViewModel(application) {


    val listOfWeather = MutableLiveData<List<ArticlesList>>()
    val weatherState = MutableLiveData<ArticlesList>()
    var weather = MutableLiveData<ListWeather>()
    var weatherIcon = MutableLiveData<Weather>()


    fun getWeatherList(){
        return setWeatherList()
    }






     private fun setWeatherList() {

        RetrofitInstance().api().getListOfHeadLine(q = "dushanbe")
            .enqueue(object : Callback<ListWeather> {
                override fun onResponse(call: Call<ListWeather>, response: Response<ListWeather>) {
                    if (response.isSuccessful){
//                        response.body()?.city?.forEach {
//                            Log.e("TAG", "onResponse: $it", )
//                            val articlesList = it

//                        }
                        response.body()?.list.let {
                            listOfWeather.postValue(it)
                        }



                        response.body().let {
                            weather.postValue(it)
                        }




                    }
                }

                override fun onFailure(call: Call<ListWeather>, t: Throwable) {
                    Log.e("ERROR", t.message.toString())
                }

            })

    }

}

