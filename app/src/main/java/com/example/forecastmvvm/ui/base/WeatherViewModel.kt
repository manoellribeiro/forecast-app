package com.example.forecastmvvm.ui.base

import androidx.lifecycle.ViewModel
import com.example.forecastmvvm.data.repository.ForecastRepository
import com.example.forecastmvvm.internal.lazyDeferred

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }

}