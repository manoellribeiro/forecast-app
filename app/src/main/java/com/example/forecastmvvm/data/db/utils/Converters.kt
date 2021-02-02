package com.example.forecastmvvm.data.db.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Converters {

    @TypeConverter
    @JvmStatic
    fun stringFromArrayList(list: ArrayList<String>): String{
        return list[0]
    }

    @TypeConverter
    @JvmStatic
    fun arrayListFromString(value: String): ArrayList<String>{
        return arrayListOf(value)
    }

    @TypeConverter
    @JvmStatic
    fun stringToDate (str: String?): LocalDate? = str?.let {
        LocalDate.parse(it, DateTimeFormatter.ISO_LOCAL_DATE)
    }

    @TypeConverter
    @JvmStatic
    fun dateToString(dateTime: LocalDate?) : String? = dateTime?.format(DateTimeFormatter.ISO_LOCAL_DATE)
}