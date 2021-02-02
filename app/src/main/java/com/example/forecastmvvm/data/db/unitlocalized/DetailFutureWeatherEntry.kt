package com.example.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo
import java.time.LocalDate

data class DetailFutureWeatherEntry (
    @ColumnInfo(name = "date")
    val date: LocalDate,
    @ColumnInfo(name = "maxtempC")
    val maxTemperature: Double,
    @ColumnInfo(name = "mintempC")
    val minTemperature: Double,
    @ColumnInfo(name = "avgtempC")
    val avgTemperature: Double,
    @ColumnInfo(name = "condition_text")
    val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    val conditionIconUrl: String,
    @ColumnInfo(name = "maxwindKph")
    val maxWindSpeed: Double,
    @ColumnInfo(name = "totalprecipMm")
    val totalPrecipitation: Double,
    @ColumnInfo(name = "avgvisKm")
    val avgVisibilityDistance: Double,
    @ColumnInfo(name = "uv")
    val uv: Double
        )