package ru.nsu.fit.kozhevnikova.weather_forecast.domain.model

import com.google.gson.annotations.SerializedName

data class ThreeHoursForecast(
    @SerializedName("weather")
    val weather : List<Weather>,
    @SerializedName("main")
    val main: Main,
    @SerializedName("wind")
    val wind : Wind,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("rain")
    val rain: Rain,
    @SerializedName("snow")
    val snow: Snow,
    @SerializedName("dt")
    val timeOfData : Long
)