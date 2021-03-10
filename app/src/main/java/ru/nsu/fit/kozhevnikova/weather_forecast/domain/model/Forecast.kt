package ru.nsu.fit.kozhevnikova.weather_forecast.domain.model

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("city")
    val city: City,
    @SerializedName("list")
    val list : List<ThreeHoursForecast>
)