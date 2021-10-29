package com.example.weatherapp.viewModel


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.data.api.RetrofitInstance
import com.example.weatherapp.data.responses.ArticlesList
import com.example.weatherapp.data.responses.ListWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(application: Application) : AndroidViewModel(application) {


    val listOfWeather = MutableLiveData<List<ArticlesList>>()
    var weather = MutableLiveData<ListWeather>()







    fun getWeatherList(city: String){
        return setWeatherList(city = city)
    }


     private fun setWeatherList(city: String) {

        RetrofitInstance().api().getListOfHeadLine(q = city)
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

