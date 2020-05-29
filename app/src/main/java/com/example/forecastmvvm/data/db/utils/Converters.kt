package com.example.forecastmvvm.data.db.utils

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<String>?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String?): ArrayList<String> = Gson().fromJson(value, ArrayList<String>()::class.java)
}