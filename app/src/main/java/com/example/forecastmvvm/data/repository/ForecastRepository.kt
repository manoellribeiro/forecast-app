package com.example.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.example.forecastmvvm.data.db.WeatherLocationDao
import com.example.forecastmvvm.data.db.entity.WeatherLocation
import com.example.forecastmvvm.data.db.unitlocalized.CurrentWeatherEntry
import com.example.forecastmvvm.data.db.unitlocalized.DetailFutureWeatherEntry
import com.example.forecastmvvm.data.db.unitlocalized.SimpleFutureWeatherEntry
import java.time.LocalDate

interface ForecastRepository {
    suspend fun getCurrentWeather(): LiveData<out CurrentWeatherEntry>
    suspend fun getFutureWeatherList(startDate: LocalDate): LiveData<out List<SimpleFutureWeatherEntry>>
    suspend fun getFutureWeatherByDate(date: LocalDate): LiveData<out DetailFutureWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}
