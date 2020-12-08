package com.example.forecastmvvm.data.db.utils

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun stringFromArrayList(list: ArrayList<String>): String{
        return list[0]
    }

    @TypeConverter
    fun arrayListFromString(value: String): ArrayList<String>{
        return arrayListOf(value)
    }
}