package com.example.forecastmvvm.ui.weather.future.list

import androidx.lifecycle.ViewModel
import com.example.forecastmvvm.data.repository.ForecastRepository
import com.example.forecastmvvm.internal.lazyDeferred
import com.example.forecastmvvm.ui.base.WeatherViewModel
import java.time.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : WeatherViewModel(forecastRepository) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now())
    }

}
