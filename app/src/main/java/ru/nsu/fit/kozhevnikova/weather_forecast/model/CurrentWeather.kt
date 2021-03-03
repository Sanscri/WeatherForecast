package ru.nsu.fit.kozhevnikova.weather_forecast.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("coord")
    val coordinates: Coordinates,
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
    val timeOfData : Long,
    @SerializedName("sys")
    val sys : Sys,
    @SerializedName("id")
    val cityId : Long,
    @SerializedName("name")
    val cityName : String
){
    override fun toString(): String {
        return cityName + weather.toString()
    }
}