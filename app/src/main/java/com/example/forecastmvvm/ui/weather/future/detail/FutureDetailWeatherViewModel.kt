package com.example.forecastmvvm.ui.weather.future.detail

import androidx.lifecycle.ViewModel
import com.example.forecastmvvm.data.repository.ForecastRepository
import com.example.forecastmvvm.internal.lazyDeferred
import com.example.forecastmvvm.ui.base.WeatherViewModel
import java.time.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository
) : WeatherViewModel(forecastRepository){

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate)
    }

}
