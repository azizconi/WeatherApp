package com.example.weatherapp.ui.screen


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.api.RetrofitInstance
import com.example.weatherapp.data.responses.ListWeather
import com.example.weatherapp.data.responses.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(application: Application) : AndroidViewModel(application) {


    val listOfWeather = MutableLiveData<List<ListWeather>>()
    var weather = MutableLiveData<ListWeather>()



    fun getWeatherList(){
        return setWeatherList()
    }



     private fun setWeatherList() {



        RetrofitInstance().api().getListOfHeadLine()
            .enqueue(object : Callback<ListWeather> {
                override fun onResponse(call: Call<ListWeather>, response: Response<ListWeather>) {
                    if (response.isSuccessful){
//                        response.body()?.city?.forEach {
//                            Log.e("TAG", "onResponse: $it", )
//                            val articlesList = it
//                        }
                        val list = response.body()
                        weather.postValue(list)

                            Log.e("TAG", "onResponse:, ")




                    }
                }

                override fun onFailure(call: Call<ListWeather>, t: Throwable) {
                    Log.e("ERROR", t.message.toString())
                }

            })

    }

}

