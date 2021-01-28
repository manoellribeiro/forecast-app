package com.example.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo
import java.time.LocalDate

data class SimpleFutureWeatherEntry(
    @ColumnInfo(name = "date")
    val date: LocalDate,
    @ColumnInfo(name = "avgtempC")
    val avgTemperature: Double,
    @ColumnInfo(name = "condition_text")
    val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    val conditionIconUrl: String
)
