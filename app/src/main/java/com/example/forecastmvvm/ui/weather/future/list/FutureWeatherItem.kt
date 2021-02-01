package com.example.forecastmvvm.ui.weather.future.list

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.forecastmvvm.R
import com.example.forecastmvvm.data.db.unitlocalized.SimpleFutureWeatherEntry
import com.example.forecastmvvm.internal.glide.GlideApp
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_future_weather.*
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class FutureWeatherItem(
    val weatherWeatherEntry: SimpleFutureWeatherEntry
): Item() {

    override fun getLayout() = R.layout.item_future_weather

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            textView_condition.text = weatherWeatherEntry.conditionText
            updateDate()
            updateTemperature()
            updateConditionImage()
        }
    }

    private fun GroupieViewHolder.updateDate() {
        val dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
        textView_date.text = weatherWeatherEntry.date.format(dateTimeFormatter)
    }

    private fun GroupieViewHolder.updateTemperature() {
        textView_temperature.text = "${weatherWeatherEntry.avgTemperature}ºC"
    }

    private fun GroupieViewHolder.updateConditionImage(){
        GlideApp.with(this.containerView)
            .load("http:" + weatherWeatherEntry.conditionIconUrl)
            .into(imageView_condition_icon)
    }

}