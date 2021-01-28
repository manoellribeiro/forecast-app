package com.example.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

data class CurrentWeatherEntry (
    @ColumnInfo(name = "temperature")
    val temperature: Double,
    @ColumnInfo(name = "weatherDescriptions")
    val conditionText: String,
    @ColumnInfo(name = "weatherIcons")
    val conditionIconUrl: String,
    @ColumnInfo(name = "windSpeed")
    val windSpeed: Double,
    @ColumnInfo(name = "windDir")
    val windDirection: String,
    @ColumnInfo(name = "precip")
    val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike")
    val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    val visibilityDistance: Double
)