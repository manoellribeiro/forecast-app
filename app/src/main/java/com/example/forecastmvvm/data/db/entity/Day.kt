package com.example.forecastmvvm.data.db.entity


import androidx.room.Embedded
import com.example.forecastmvvm.data.db.entity.Condition
import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("avgtemp_c")
    val avgtempC: Double,
    @SerializedName("avgvis_km")
    val avgvisKm: Double,
    @Embedded(prefix = "condition_")
    val condition: Condition,
    @SerializedName("daily_chance_of_rain")
    val dailyChanceOfRain: String,
    @SerializedName("daily_chance_of_snow")
    val dailyChanceOfSnow: String,
    @SerializedName("daily_will_it_rain")
    val dailyWillItRain: Int,
    @SerializedName("daily_will_it_snow")
    val dailyWillItSnow: Int,
    @SerializedName("maxtemp_c")
    val maxtempC: Double,
    @SerializedName("maxwind_kph")
    val maxwindKph: Double,
    @SerializedName("mintemp_c")
    val mintempC: Double,
    @SerializedName("totalprecip_mm")
    val totalprecipMm: Double,
    val uv: Double
)