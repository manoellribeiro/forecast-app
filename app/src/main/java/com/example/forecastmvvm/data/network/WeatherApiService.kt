package com.example.forecastmvvm.data.network

import com.example.forecastmvvm.data.network.response.CurrentWeatherResponse
import com.example.forecastmvvm.data.network.response.FutureWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val WEATHER_API_KEY = "4fb7ffd07fc042d2aac142433212801"

//http://api.weatherapi.com/v1/forecast.json?key=4fb7ffd07fc042d2aac142433212801&q=London&days=1

interface WeatherApiService {


    @GET("forecast.json")
    fun getFutureWeather(
        @Query("q") location: String,
        @Query("days") days: Int
    ): Deferred<FutureWeatherResponse>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): WeatherApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key",
                        APIXU_API_KEY
                    )
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherapi.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService::class.java)
        }
    }

}