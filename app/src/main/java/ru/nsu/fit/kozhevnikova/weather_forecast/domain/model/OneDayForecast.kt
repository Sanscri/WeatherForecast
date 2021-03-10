package ru.nsu.fit.kozhevnikova.weather_forecast.domain.model

import com.google.gson.annotations.SerializedName

data class OneDayForecast(
    @SerializedName("dt")
    val dateTime: Long,
    @SerializedName("temp")
    val temperature: Temperature,
    @SerializedName("pressure")
    val pressure: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("speed")
    val windSpeed: Double,
    @SerializedName("deg")
    val windDegrees: Double,
    @SerializedName("clouds")
    val clouds: Double,
    @SerializedName("snow")
    val snow: Double,
    @SerializedName("rain")
    val rain: Double
)
