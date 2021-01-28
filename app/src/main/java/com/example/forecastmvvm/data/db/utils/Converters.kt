package com.example.forecastmvvm.data.db.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Converters {

    @TypeConverter
    fun stringFromArrayList(list: ArrayList<String>): String{
        return list[0]
    }

    @TypeConverter
    fun arrayListFromString(value: String): ArrayList<String>{
        return arrayListOf(value)
    }

    @TypeConverter
    fun stringToDate (str: String?): LocalDate? = str?.let {
        LocalDate.parse(it, DateTimeFormatter.ISO_LOCAL_DATE)
    }

    @TypeConverter
    fun dateToString(dateTime: LocalDate?) : String? = dateTime?.format(DateTimeFormatter.ISO_LOCAL_DATE)
}